package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.TopicService;
import ru.job4j.forum.service.UserService;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;
    private TopicService topicService;
    private UserService userService;

    public CommentController(CommentService commentService, TopicService topicService, UserService userService) {
        this.commentService = commentService;
        this.topicService = topicService;
        this.userService = userService;
    }

    @GetMapping("/comments")
    public String getComments(@RequestParam("tId") Integer tId, Model model, Principal principal) {
        Topic topic = topicService.findById(tId);
        List<Comment> comments = topic.getComments();
        comments.sort(Comparator.comparing(Comment::getCreated));
        model.addAttribute("comments", comments);
        model.addAttribute("post", topic.getPost().getName());
        model.addAttribute("topic", topic.getName());
        model.addAttribute("tId", topic.getId());
        model.addAttribute("user", principal.getName());
        return "comments";
    }

    @GetMapping("/create")
    public String createComment(@RequestParam("tId") Integer tId, Model model) {
        model.addAttribute("tId", tId);
        return "comment/save";
    }

    @PostMapping("/save")
    public String saveComment(@ModelAttribute Comment comment, @RequestParam("tId") Integer tId,
                              Principal principal) {
        comment.setTopic(topicService.findById(tId));
        comment.setAuthor(userService.findByUsername(principal.getName()));
        commentService.save(comment);
        return "redirect:/comments/comments?tId=" + tId;
    }
}
