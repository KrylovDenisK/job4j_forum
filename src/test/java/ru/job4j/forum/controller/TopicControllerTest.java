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
import ru.job4j.forum.service.PostService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest(classes = Job4jForumApplication.class)
@AutoConfigureMockMvc
public class TopicControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService postService;

    @WithMockUser
    @Test
    public void returnDefaultTopics() throws Exception  {
        Post post = Post.of("Раздел");
        Mockito.when(postService.findById(1)).thenReturn(post);
        mockMvc.perform(get("/topics/topics").param("pId", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("topic"));
    }
}