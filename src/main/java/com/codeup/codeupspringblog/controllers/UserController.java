package com.codeup.codeupspringblog.controllers;

import org.springframework.ui.Model;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    //    ***** DEPENDENCY INJECTION FIELD/S *****
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    //    ***** CONSTRUCTORS *******
    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userRepository = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up-form";
    }

    @PostMapping("/signup")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        return "redirect:/login";
    }
}

