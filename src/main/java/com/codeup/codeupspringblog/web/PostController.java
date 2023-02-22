package com.codeup.codeupspringblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private List<Post> posts = new ArrayList<>();


//    ****** View all posts *******
    @GetMapping("/posts/show")
    public String viewAllPosts(Model model){

        Post post2 = new Post(2, "My Second Post","This is the body of my Second post");
        Post post3 = new Post(3, "My Third Post","This is the body of my Third post");
        Post post4 = new Post(4, "My Fourth Post","This is the body of my Fourth post");


        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

        model.addAttribute("postList", posts);

        return "posts/show";
    }

    //    ****** View posts by ID *******
    @GetMapping("/posts/index")
    public String viewSinglePost(Model model){

        Post post1 = new Post(1,"My First Post", "This is the body of my first post");

        model.addAttribute("firstPost", post1);

        return "posts/index";
    }

    //    ****** View form for creating a post *******
    @GetMapping("/posts/create")
    public String createPostsForm(){
        return "posts/posts-form";
    }

//        ****** Create a new post *******
    @PostMapping("/posts/create")
    public String createNewPost(@RequestParam(name = "title") String title, @RequestParam String body){
        Post newPost = new Post(posts.size() + 1, title, body);
        posts.add(newPost);
        return "redirect:/posts/show";
    }

}
