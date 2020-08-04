package com.codeup.springblog;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "/posts/index";
    }

    @PostMapping(path = "/posts/delete", name = "delete_post_id")
    public String deletePost(@RequestParam(name = "delete_post_id") long id, Model model) {
        postsDao.deleteById(id);
        posts(model);
        return "/posts/index";
    }

    @PostMapping(path = "/posts/edit", name = "edit_post_id")
    public String editPost(@RequestParam(name = "edit_post_id") long id, Model model) {
        Post post = postsDao.getOne(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @PostMapping(path = "/posts/show")
    public String submitEditPost(@RequestParam(name = "change_post_id") long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body,  Model model) {
        postsDao.save(new Post(id, title, body));
        posts(model);
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
