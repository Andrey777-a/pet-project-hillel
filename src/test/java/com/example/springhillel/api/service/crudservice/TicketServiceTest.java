package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.model.dto.TicketDTO;
import com.example.springhillel.model.entity.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TicketServiceTest {

    private static Ticket ticket;
    private static TicketDTO ticketDTO;

    @Mock
    private TicketService ticketService;

    @BeforeAll
    public static void beforeAll() {
        ticketDTO = new TicketDTO("ticket", "new ticket", 1, 1, 2, 0.0, null, null, 1);
        ticket = new Ticket("ticket", "new ticket", null, null, 2, 0.0, null, null, null);
    }

    @Test
    public void testCreateTicket(){

        ticketService.save(ticketDTO);

        ArgumentCaptor<TicketDTO> requestCaptor = ArgumentCaptor.forClass(TicketDTO.class);

        Mockito.verify(ticketService).save(requestCaptor.capture());

        assertFalse(requestCaptor.getAllValues().isEmpty());
        TicketDTO capturedArgument = requestCaptor.getValue();
        assertEquals("ticket", capturedArgument.getName());

    }

    @Test
    public void testGetAllTicket(){

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        Mockito.when(ticketService.getAll()).thenReturn(ticketList);

        assertEquals("ticket", ticketService.getAll().get(0).getName());

        Mockito.verify(ticketService).getAll();


    }

    @Test
    public void testFindByIdTicket(){

        Optional<Ticket> ticketOptional = Optional.of(ticket);

        Mockito.when(ticketService.findById(1)).thenReturn(ticketOptional);

        assertEquals("ticket", ticketService.findById(1).get().getName());

        Mockito.verify(ticketService).findById(1);

    }

    @Test
    public void testDeleteTicket(){

        ticketService.deleteById(1);

        Mockito.verify(ticketService).deleteById(1);

    }

    @Test
    public void testUpdateTicket(){

        ticketService.update(ticket);

        Mockito.verify(ticketService).update(ticket);

    }

}