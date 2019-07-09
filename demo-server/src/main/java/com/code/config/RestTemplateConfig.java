package com.code.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * @author ccy
 */
@Configuration
@Slf4j
public class RestTemplateConfig {
    /**
     * 从连接池中获取连接的超时时间，超过该时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
     */
    private static int requestTimeout = 10000;

    /**
     * 连接上目标服务器(握手成功)的时间，超出该时间抛出connect timeout
     */
    private static int connectTimeout = 5000;
    /**
     * 目标服务器返回数据(response)的时间，超过该时间抛出read timeout
     */
    private static int readTimeout = 30000;
    private static int connectionsPerRoute = 200;
    private static int connectionsTotal = 500;


    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    /**
     * 注册全局请求参数转换器
     * 参考:https://blog.csdn.net/fansili/article/details/78366874
     */
//    @PostConstruct
//    public void initEditableAvlidation() {
//        log.info("RestTemplateConfig initEditableAvlidation");
//        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
//        if(initializer.getConversionService()!=null) {
//            GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();
//
//            //配置两个同样是 Converter<String, Date> 后面配置的会覆盖前面的
//            genericConversionService.addConverter(new TimeStmpToDateConverter());
//            genericConversionService.addConverter(new StringToDateConverter());
//
//        }
//
//    }

    /**
     * @return
     */
    @Bean
    @Qualifier("httpclientRestTemplate")
    public RestTemplate httpclientRestTemplate() {
        log.info("RestTemplateConfig httpclientRestTemplate bean");
        CloseableHttpClient closeableHttpClient = buildHttpclient();
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(closeableHttpClient);
        clientHttpRequestFactory.setConnectionRequestTimeout(requestTimeout);
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        return new RestTemplate(clientHttpRequestFactory);
    }





    /**
     * 配置参考 https://www.jianshu.com/p/6a41c95855e3
     * 没有使用重试机制
     *
     * @return
     */
    private CloseableHttpClient buildHttpclient() {
        //连接池设置
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        connManager.setMaxTotal(connectionsTotal);
        // 设置每个连接的路由数
        connManager.setDefaultMaxPerRoute(connectionsPerRoute);

        // 创建Http请求配置参数
        RequestConfig requestConfig = RequestConfig.custom()
                // 获取连接超时时间
                .setConnectionRequestTimeout(requestTimeout)
                // 请求超时时间
                .setConnectTimeout(connectTimeout)
                // 响应超时时间
                .setSocketTimeout(readTimeout)
                .build();

        // 创建httpClient
        return HttpClients.custom()
                // 把请求相关的超时信息设置到连接客户端
                .setDefaultRequestConfig(requestConfig)
//                // 把请求重试设置到连接客户端
//                .setRetryHandler(retry)
                // 配置连接池管理对象
                .setConnectionManager(connManager)
                .build();
    }
}
