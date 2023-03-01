package com.codeup.codeupspringblog.service;

import com.codeup.codeupspringblog.repositories.PostRepository;

public class PostService {

    private final UserService userService;
    private final PostRepository postRepository;


    public PostService(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }


}
