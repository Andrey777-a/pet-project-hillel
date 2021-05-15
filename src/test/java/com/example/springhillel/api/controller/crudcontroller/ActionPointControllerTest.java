package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.service.crudservice.ActionPointService;
import com.example.springhillel.model.dto.ActionPointDTO;
import com.example.springhillel.model.entity.ActionPoint;
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
@WebMvcTest(value = ActionPointController.class)
public class ActionPointControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActionPointService actionPointService;

    private ActionPointDTO actionPointDTO;
    private ActionPoint actionPoint;

    @Before
    public void before() {
        actionPointDTO = new ActionPointDTO("TEST_ACTION_POINT");
        actionPoint = new ActionPoint("TEST_ACTION_POINT");
    }

    @Test
    public void testGettingAllActionPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/action-point")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(actionPointService).getAll();
    }

    @Test
    public void testGettingActionPointById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/action-point/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(actionPointService).findById(2);
    }

    @Test
    public void testSaveActionPoint() throws Exception {

        actionPointService.save(actionPointDTO);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/action-point")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toObjectMap(actionPointDTO))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetAllWithBodyActionPoint() throws Exception {

        List<ActionPoint> list = new ArrayList<>();
        list.add(actionPoint);

        Mockito.when(actionPointService.getAll()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/action-point")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("TEST_ACTION_POINT"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteActionPoint() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/action-point/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private String toObjectMap(ActionPointDTO dto) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dto);
    }
}