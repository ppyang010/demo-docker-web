package com.code.processor.api;

import com.alibaba.fastjson.JSON;
import com.code.domain.vo.ZhiHuHotVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ccy
 */
@Component
@AllArgsConstructor
public class ZhiHuHotApiProcessor  {

    private RestTemplate restTemplate;

    public void execute(){
        ZhiHuHotVO root = restTemplate.getForObject("https://www.zhihu.com/api/v3/feed/topstory/hot-lists/digital?limit=50&desktop=true", ZhiHuHotVO.class);
        List<ZhiHuHotVO.Data> data = Optional.ofNullable(root).map(ZhiHuHotVO::getData).orElse(new ArrayList<>());


        System.out.println(JSON.toJSONString(root));
    }
}
