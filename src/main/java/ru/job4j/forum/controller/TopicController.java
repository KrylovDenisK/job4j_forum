package ru.job4j.forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.TopicService;
import ru.job4j.forum.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/topics")
public class TopicController {
    private TopicService topicService;
    private PostService postService;
    private UserService userService;

    public TopicController(TopicService topicService, PostService postService, UserService userService) {
        this.topicService = topicService;
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/topics")
    public String getTopics(@RequestParam("pId") Integer pId, Model model, Principal principal) {
        Post post = postService.findById(pId);
        model.addAttribute("topics", post.getTopics());
        model.addAttribute("postName", post.getName());
        model.addAttribute("pId", pId);
        model.addAttribute("user", principal.getName());
        return "topic";
    }

    @GetMapping("/create")
    public String createPost(@RequestParam("pId") Integer pId, Model model,
                             Principal principal) {
        model.addAttribute("pId", pId);
        model.addAttribute("user", principal.getName());
        return "topic/save";
    }

    @PostMapping({"/save", "/edit"})
    public String save(@RequestParam("pId") Integer pId, @ModelAttribute Topic topic, Principal principal) {
        topic.setAuthor(userService.findByUsername(principal.getName()));
        Post post = postService.findById(pId);
        topic.setPost(post);
        topicService.saveOrUpdate(topic);
        return "redirect:/topics/topics?pId=" + pId;
    }

    @GetMapping("/edit")
    public String getTopicForEdit(@RequestParam("tId") Integer tId, Model model,
                                  Principal principal) {
        model.addAttribute("topic", topicService.findById(tId));
        model.addAttribute("user", principal.getName());
        return "topic/update";
    }

//    @PostMapping("/edit")
//    public String editTopic(@ModelAttribute Topic topic, @RequestParam("pId") Integer pId) {
//        topicService.save(topic);
//        return "/topics/topics";
//    }
}
