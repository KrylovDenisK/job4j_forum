package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Job4jForumApplication;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.Topic;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.TopicService;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = Job4jForumApplication.class)
@AutoConfigureMockMvc
public class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    @MockBean
    private CommentService commentService;


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

    @Test
    @WithMockUser
    public void whenCommentMethodGetCreate() throws Exception {
        mockMvc.perform(get("/comments/create").param("tId", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("comment/save"));
    }

    @Test
    @WithMockUser
    public void whenCommentMethodPostSave() throws Exception {
        mockMvc.perform(
                post("/comments/save")
                        .param("tId", "1")
                        .param("text", "Привет! Как дела???"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Comment> argumentCaptor = ArgumentCaptor.forClass(Comment.class);
        Mockito.verify(commentService).save(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue().getText(), "Привет! Как дела???");
    }




}