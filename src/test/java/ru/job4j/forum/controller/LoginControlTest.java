package ru.job4j.forum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Job4jForumApplication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Job4jForumApplication.class)
@AutoConfigureMockMvc
public class LoginControlTest {
    @Autowired
    private MockMvc mockMvc;

    @WithMockUser
    @Test
    public void returnDefaultTopics() throws Exception  {
        mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("auth/login"));
    }

}