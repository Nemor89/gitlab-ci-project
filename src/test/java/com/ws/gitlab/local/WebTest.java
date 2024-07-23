package com.ws.gitlab.local;

import com.ws.gitlab.local.entity.User;
import com.ws.gitlab.local.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WebTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllUsers() throws Exception {
        User testUser = new User();
        testUser.setName("Test User");
        Mockito.when(userRepository.findAll()).thenReturn(List.of(testUser));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/get/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value(testUser.getName()));
    }
}
