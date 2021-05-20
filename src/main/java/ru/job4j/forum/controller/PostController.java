package ru.job4j.forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String createPost() {
        return "post/save";
    }

    @PostMapping({"/save", "/edit"})
    public String save(@ModelAttribute Post post) {
        service.save(post);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String getPostForEdit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("post", service.getPostById(id));
        return "post/update";
    }
}
