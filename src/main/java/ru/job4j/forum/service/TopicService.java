package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.TopicRepository;


@Service
public class TopicService {
    private TopicRepository topicRepository;
    //private UserService userService;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
        //this.userService = userService;
    }

//    public List<Topic> findTopicsByPostId(Integer id) {
//        List<Topic> topics = new ArrayList<>();
//        postRepository.findById(id).ifPresent(x -> topics.addAll(x.getTopics()));
//        return topics;
//    }

    public void saveOrUpdate(Topic topic) {
        topicRepository.save(topic);
    }

    public void save(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic findById(Integer tId) {
        return topicRepository.findById(tId).orElse(new Topic());
    }
}
