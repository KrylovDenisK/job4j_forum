package ru.job4j.forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/post")
public class PostController {
    private PostService postService;
    private UserService userService;

    public PostController(PostService service, UserService userService) {
        this.postService = service;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createPost(Model model, Principal principal) {
        model.addAttribute("user", principal.getName());
        return "post/save";
    }

    @PostMapping({"/save", "/edit"})
    public String save(@ModelAttribute Post post, Principal principal) {
        post.setAuthor(userService.findByUsername(principal.getName()));
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getPostForEdit(@RequestParam("id") Integer id, Model model,
                                 Principal principal) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("user", principal.getName());
        return "post/update";
    }
}
