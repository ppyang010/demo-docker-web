package com.code.service;

import com.code.domain.model.Post;

import java.util.Optional;

public interface PostService {

    Optional<Post> findById(Integer id);

    Post save(Post post);
}
