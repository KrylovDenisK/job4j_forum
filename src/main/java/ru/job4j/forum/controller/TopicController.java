package ru.job4j.forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.TopicService;

@Controller
@RequestMapping("/topics")
public class TopicController {
    private TopicService topicService;
    private PostService postService;

    public TopicController(TopicService topicService, PostService postService) {
        this.topicService = topicService;
        this.postService = postService;
    }

    @GetMapping("/topics")
    public String getTopics(@RequestParam("pId") Integer pId, Model model) {
        Post post = postService.getPostById(pId);
        model.addAttribute("topics", post.getTopics());
        model.addAttribute("postName", post.getName());
        model.addAttribute("pId", pId);
        return "topic";
    }

    @GetMapping("/create")
    public String createPost(@RequestParam("pId") Integer pId, Model model) {
        model.addAttribute("pId", pId);
        return "topic/save";
    }

    @PostMapping({"/save", "/edit"})
    public String save(@RequestParam("pId") Integer pId, @ModelAttribute Topic topic) {
        topicService.saveOrUpdate(topic, pId);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String getTopicForEdit(@RequestParam("tId") Integer tId, Model model) {
        model.addAttribute("topic", topicService.findById(tId));
        return "topic/update";
    }

//    @PostMapping("/edit")
//    public String editTopic(@ModelAttribute Topic topic, @RequestParam("pId") Integer pId) {
//        topicService.save(topic);
//        return "/topics/topics";
//    }
}
