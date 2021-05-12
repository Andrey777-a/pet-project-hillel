package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.service.crudservice.TicketService;
import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
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
@WebMvcTest(value = TicketController.class)
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    private Ticket ticket;

    private TicketDTO ticketDTO;

    @Before
    public void before() {
        ticketDTO = new TicketDTO("test_ticket", "new ticket", 1, 1, 2, 0.0, null, null, 1);
        ticket = new Ticket("test_ticket", "new ticket", null, null, 2, 0.0, null, null, null);

    }

    @Test
    public void testGettingAllTicket() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ticketService).getAll();
    }

    @Test
    public void testGettingTicketById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/ticket/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ticketService).findById(2);
    }

    @Test
    public void testSaveTicket() throws Exception {

        ticketService.save(ticketDTO);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toObjectMap(ticketDTO))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testGetAllWithBodyTicket() throws Exception {

        List<Ticket> list = new ArrayList<>();
        list.add(ticket);

        Mockito.when(ticketService.getAll()).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("test_ticket"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ticketService).getAll();
    }

    @Test
    public void testDeleteTicket() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/ticket/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(ticketService).deleteById(2);
    }

    private String toObjectMap(TicketDTO dto) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dto);
    }

}