package com.codeup.codeupspringblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {


//    ****** View all posts *******
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "posts";
    }

    //    ****** View posts by ID *******
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String posts(@PathVariable int id){
        return "<h1>" + "post with ID of: " + id + "</h1>";
    }

    //    ****** View form for creating a post *******
    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostsForm(){
        return "posts";
    }

    //    ****** Create a new post *******
    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(){
        return "posts";
    }


//    ***** Views for index and show html files. ******
    @GetMapping("/posts/index")
    public String viewIndex(){
        return "posts/index";
    }

    @GetMapping("/posts/show")
    public String viewShow(){
        return "posts/show";
    }

}
