package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

//    ***** DEPENDENCY INJECTION FIELD/S *****
    private UserRepository userRepository;
    private PostRepository postRepository;
    private UserService userService;

//    ***** CONSTRUCTORS *******

    public UserController(UserRepository userRepository, PostRepository postRepository, UserService userService) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    //******** GET BY EMAIL *************
    @GetMapping("/{email}")
    public String getByEmail(@PathVariable String email) {
        userRepository.findByEmail(email);
        System.out.println(email);
        return email;
    }

    @GetMapping("/username")
    public User getByUsername(@RequestParam String username) {
        return userService.getUsername(username);
    }

}
