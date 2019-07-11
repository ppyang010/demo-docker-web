package com.code.service;

import com.alibaba.fastjson.JSON;
import com.code.domain.model.Post;
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
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    public void findById(){
        System.out.println(JSON.toJSONString(postService.findById(1)));
    }

    @Test
    public void save() {
        System.out.println(postService.save(new Post()
                .setTitle("best")
                .setPostFrom(10)
                .setPostUrl("")
                .setAuthor("")
                .setIntro("")
                .setAuthorAvatar("")));
    }
}
