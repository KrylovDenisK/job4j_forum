package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private TopicService topicService;
    private UserService userService;

    public CommentService(CommentRepository commentRepository, TopicService topicService, UserService userService) {
        this.commentRepository = commentRepository;
        this.topicService = topicService;
        this.userService = userService;
    }

    public List<Comment> getAll() {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);
        return comments;
    }

    public void save(Comment comment, Integer tId) {
        comment.setTopic(topicService.findById(tId));
        comment.setAuthor(userService.findById(3));
        commentRepository.save(comment);
    }

}
