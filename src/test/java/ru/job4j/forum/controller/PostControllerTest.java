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
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Job4jForumApplication.class)
@AutoConfigureMockMvc
public class PostControllerTest {
    @MockBean
    private PostService postService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void whenGetMethodCreatePost() throws Exception {
        mockMvc.perform(get("/post/create"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("post/save"));
    }

    @Test
    @WithMockUser
    public void whenPostMethodCreatePost() throws Exception {
        mockMvc.perform(post("/post/save").param("name", "Java Core"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argumentCaptor = ArgumentCaptor.forClass(Post.class);
        Mockito.verify(postService).save(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue().getName(), "Java Core");
    }

    @Test
    @WithMockUser
    public void whenGetMethodEditPost() throws Exception {
        mockMvc.perform(get("/post/edit").param("id", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("post/update"));
    }



}