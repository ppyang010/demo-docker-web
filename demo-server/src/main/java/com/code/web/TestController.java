package com.code.web;

import com.code.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ccy
 */
@RestController
@AllArgsConstructor
public class TestController {
    private PostService postService;

}
