package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postsDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "/posts/index";
    }

    @PostMapping(path = "/posts/delete", name = "delete_post_id")
    public String deletePost(@RequestParam(name = "delete_post_id") long id, Model model) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping(path = "/posts/show")
    public String submitEditPost(@RequestParam(name = "change_post_id") long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body,  Model model) {
        postsDao.save(new Post(id, title, body));
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        User user = post.getParentUser();
        model.addAttribute("post", post);
        model.addAttribute("user", user);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm() {
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body,  Model model) {
        Post post = new Post(title, body);
        User user = usersDao.getOne((long) 2);
        post.setParentUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }
}
