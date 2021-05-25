package ru.job4j.forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.service.PostService;

import java.security.Principal;

@Controller
public class IndexController {
    private PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model, Principal principal) {
        model.addAttribute("posts", postService.getAll());
        model.addAttribute("user", principal.getName());
        return "index";
    }
}
