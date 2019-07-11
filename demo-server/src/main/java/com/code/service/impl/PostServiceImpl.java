package com.code.service.impl;

import com.code.dao.PostRepository;
import com.code.domain.model.Post;
import com.code.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ccy
 */
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Override
    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
