package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

//    ***** DEPENDENCY INJECTION FIELD/S *****
    private PostRepository postDao;
    private UserRepository userDao;

//    ***** CONSTRUCTORS *******

    public PostController(UserRepository userDao, PostRepository postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }

//    ****** View all posts *******
    @GetMapping("/posts/show")
    public String viewAllPosts(Model model){

        model.addAttribute("postList", postDao.findAll());

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
        User user = userDao.getById(1L);
        Post newPost = new Post(title, body);
        newPost.setUser(user);
        postDao.save(newPost);
        return "redirect:/posts/show";
    }

//       ****** View posts by ID *******

//    @GetMapping("post/individual-post")
//    public String viewPostById(){
//        return "posts/individual-post";
//    }

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, String userEmail, Model model) {

//        System.out.println(user.getEmail());
        model.addAttribute("indiPost", postDao.findById(id).get());
        model.addAttribute("userNameOfPoster", userDao.findByEmail(userEmail));
        System.out.println(userDao.findByEmail(userEmail));
        return "/posts/individual-post";
    }


}
