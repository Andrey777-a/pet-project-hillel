package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.service.crudservice.UserService;
import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    private UserDTO userDTO;

    @Before
    public void before() {
        user = new User("Test_name", "Test_last_name", "Test_password", "Test_email");
        userDTO = new UserDTO("Test_name", "Test_last_name", "Test_password", "Test_email", 1);
    }

    @Test
    public void testGettingAllUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService).getAll();
    }

    @Test
    public void testGettingUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService).findById(2);
    }

    @Test
    public void testSaveUser() throws Exception {

        userService.save(userDTO);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toObjectMap(userDTO))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testGetAllWithBodyUser() throws Exception {

        List<User> list = new ArrayList<>();
        list.add(user);

        Mockito.when(userService.getAll()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Test_name"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService).getAll();
    }

    @Test
    public void testDeleteUser() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/user/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService).deleteById(2);
    }

    private String toObjectMap(UserDTO dto) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dto);
    }
}