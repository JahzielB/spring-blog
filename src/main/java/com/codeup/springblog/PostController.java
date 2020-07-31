package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "This is where posts will be.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable int id) {
        return "This is where a post with an id of " + id + " will be.";
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
