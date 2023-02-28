package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
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

    //    ****** View a single designated post *******
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

//       ****** View posts by ID *******

//    @GetMapping("post/individual-post")
//    public String viewPostById(){
//        return "posts/individual-post";
//    }

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, Model model) {
        for (Post post : posts) {
            if (post.getId() == id) {
                model.addAttribute("indiPost", post);
            }
        }
        return "/posts/individual-post";
    }


}
