package com.codeup.codeupspringblog.service;

import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final UserService userService;
    private final PostRepository postRepository;


    public PostService(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }


}
