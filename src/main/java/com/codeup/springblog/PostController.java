package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String posts(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("post1", "post1body"));
        posts.add(new Post("post2", "post2body"));
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model model) {
        Post myPost = new Post(1, "test", "testestset");
        model.addAttribute("post", myPost);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "This is where the form for creating a post will be.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This is where posts will be created.";
    }
}
