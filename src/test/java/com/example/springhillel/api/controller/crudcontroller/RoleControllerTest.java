package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.service.crudservice.RoleService;
import com.example.springhillel.model.dto.RoleDTO;
import com.example.springhillel.model.entity.Role;
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
@WebMvcTest(value = RoleController.class)
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    private Role role;

    private RoleDTO roleDTO;

    @Before
    public void before() {
        role = new Role("TEST_ADMIN");
        roleDTO = new RoleDTO("TEST_ADMIN");
    }

    @Test
    public void testGettingAllRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/role")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(roleService).getAll();
    }

    @Test
    public void testGettingRoleById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/role/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(roleService).findById(2);
    }

    @Test
    public void testSaveRole() throws Exception {

        roleService.save(roleDTO);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/role")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toObjectMap(roleDTO))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAllWithBodyRole() throws Exception {

        List<Role> list = new ArrayList<>();
        list.add(role);

        Mockito.when(roleService.getAll()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/role")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("TEST_ADMIN"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteRole() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/role/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String toObjectMap(RoleDTO dto) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dto);
    }


}