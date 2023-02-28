package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;

public class UserController {

//    ***** DEPENDENCY INJECTION FIELD/S *****
    private UserRepository userDao;
    private PostRepository postDao;

//    ***** CONSTRUCTORS *******

    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    public UserController(PostRepository postDao) {
        this.postDao = postDao;
    }
}
