package com.code.processor;

import com.code.domain.vo.ZhiHuHotVO;
import com.code.processor.api.ZhiHuHotApiProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ccy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZhiHuHotApiProcessorTest {
    @Autowired
    private ZhiHuHotApiProcessor zhiHuHotApiProcessor;

    @Test
    public void execute(){
        zhiHuHotApiProcessor.execute();
    }
}
