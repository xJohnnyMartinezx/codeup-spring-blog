package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

//    ***** DEPENDENCY INJECTION FIELD/S *****
    private PostRepository postRepository;
    private UserRepository userRepository;

    private UserService userService;

//    ***** CONSTRUCTORS *******

    public PostController(UserRepository userRepository, PostRepository postRepository, UserService userService) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

//    ****** View all posts *******
    @GetMapping("/posts/show")
    public String viewAllPosts(Model model){

        model.addAttribute("postList", postRepository.findAll());

        return "posts/show";
    }

    //    ****** View a single designated post *******
//    @GetMapping("/posts/index")
//    public String viewSinglePost(Model model){
//
//
//        model.addAttribute("firstPost", postDao.);
//
//        return "posts/index";
//    }

    //    ****** View form for creating a post *******
    @GetMapping("/posts/create")
    public String createPostsForm(){
        return "posts/create-posts-form";
    }

//        ****** Create a new post *******
    @PostMapping("/posts/create")
    public String createNewPost(@RequestParam String title, @RequestParam String body ){
        User user = userRepository.getById(1L);
        Post newPost = new Post(title, body);
        newPost.setUser(user);
        postRepository.save(newPost);
        return "redirect:/posts/show";
    }

//       ****** View posts by ID *******

//    @GetMapping("post/individual-post")
//    public String viewPostById(){
//        return "posts/individual-post";
//    }

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, @RequestParam String email, Model model) {
        model.addAttribute("indiPost", postRepository.findById(id).get());
        model.addAttribute("userEmail", userRepository.findByEmail(email));
        return "/posts/individual-post";
    }

//    @GetMapping("/{email}")
//    public User getUserEmail(@PathVariable String userEmail){
//        return userRepository.findByEmail(userEmail);
//    }


}
