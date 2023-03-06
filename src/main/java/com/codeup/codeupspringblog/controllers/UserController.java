package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;



@Controller
public class UserController {

//    ***** DEPENDENCY INJECTION FIELD/S *****
    private UserRepository userRepository;
    private PostRepository postRepository;

//    ***** CONSTRUCTORS *******

    public UserController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

}
