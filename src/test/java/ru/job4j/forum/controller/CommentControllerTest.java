package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Job4jForumApplication;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.TopicService;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = Job4jForumApplication.class)
@AutoConfigureMockMvc
public class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;


    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        Topic topic = Topic.of(1, "Тема", new ArrayList<>(), Post.of("Раздел"));
        Mockito.when(topicService.findById(any())).thenReturn(topic);
        this.mockMvc.perform(get("/comments/comments").param("tId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("comments"));
    }
}