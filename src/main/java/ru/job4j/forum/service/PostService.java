package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public void save(Post post) {
       post.setAuthor(userService.findById(3));
       postRepository.save(post);
    }

    public Post getPostById(Integer id) {
        return postRepository.findById(id).orElse(new Post());
    }
}
