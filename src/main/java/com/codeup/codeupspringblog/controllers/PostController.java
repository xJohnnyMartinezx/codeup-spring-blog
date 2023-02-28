package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
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
    public String createNewPost(@RequestParam String title, @RequestParam String body){
        Post newPost = new Post(title, body);
        postDao.save(newPost);
        return "redirect:/posts/show";
    }

//       ****** View posts by ID *******

//    @GetMapping("post/individual-post")
//    public String viewPostById(){
//        return "posts/individual-post";
//    }

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, Model model) {
                model.addAttribute("indiPost", postDao.findById(id).get());
        return "/posts/individual-post";
    }


}
