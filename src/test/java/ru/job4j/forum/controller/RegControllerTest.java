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
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Job4jForumApplication.class)
@AutoConfigureMockMvc
public class RegControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    @WithMockUser
    public void returnDefaultTopics() throws Exception  {
        mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("auth/reg"));
    }

    @Test
    @WithMockUser
    public void whenPostMethodSaveTopic() throws Exception {
        Mockito.when(userService.userVerification(any())).thenReturn(true);
        mockMvc.perform(
                post("/reg")
                        .param("username", "root"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userService).createUser(argumentCaptor.capture());
        assertEquals(argumentCaptor.getValue().getUsername(), "root");
    }
}