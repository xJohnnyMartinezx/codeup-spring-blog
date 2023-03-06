package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    //    ***** DEPENDENCY INJECTION FIELD/S *****
    private PostRepository postRepository;
    private UserRepository userRepository;

    //    ***** CONSTRUCTORS *******
    public PostController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    //    ****** View all posts *******
    @GetMapping("/posts/show")
    public String viewAllPosts(Model model) {
    //   USING MODEL BINDING TO GET A LIST OF ALL POST BY USING POST REPO findAll() METHOD. ATTRIBUTE NAME IS: postList.
        model.addAttribute("postList", postRepository.findAll());
        return "posts/show";
    }

    //    ****** View form for creating a post (MODEL BIDING) *******
    @GetMapping("/posts/create")
    public String createPostsForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create-posts-form";
    }

    //    ****** Create a new post (MODEL BIDING & ASSIGNED USER MANUALLY) *******
    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post post) {
//        MANUALLY GETTING/PICKING A USER
        User user = userRepository.getById(1L);
//        ASSIGNING THE CREATED POST TO THE USER
        post.setUser(user);
//        SAVING THE CREATED POST TO POSTS REPO
        postRepository.save(post);
//        REDIRECTING TO VIEW ALL POSTS PAGE
        return "redirect:/posts/show";
    }

    //        ****** Edit an existing Post *******
    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("indiPost", postRepository.findById(id).get());
        return "posts/edit-post-form";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts/" + id;
    }

//        //    ****** View form for creating a post WITHOUT MODEL BINDING *******
//        @GetMapping("/posts/create")
//        public String createPostsForm(){
//            return "posts/create-posts-form";
//        }
//
////        ****** Create a new post WITHOUT MODEL BINDING and with a designated user *******
//        @PostMapping("/posts/create")
//        public String createNewPost(@RequestParam String title, @RequestParam String body ){
//            User user = userRepository.getById(1L);
//            Post newPost = new Post(title, body);
//            newPost.setUser(user);
//            postRepository.save(newPost);
//            return "redirect:/posts/show";
//        }


//       ****** View posts by ID *******

    @GetMapping("post/individual-post")
    public String viewPostById() {
        return "posts/individual-post";
    }

    @GetMapping("/posts/{id}")
    public String postById(@PathVariable long id, Model model) {
        model.addAttribute("indiPost", postRepository.findById(id).get());
        return "posts/individual-post";
    }


}
