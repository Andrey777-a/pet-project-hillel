package com.example.springhillel.api.service.pagination;

import com.example.springhillel.model.entity.Ticket;
import com.example.springhillel.repository.jpacrudrepozitory.TicketPagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationService{

    @Autowired
    private TicketPagingRepository abstractRepository;

    public List<Ticket> getAllTicket(Integer page, Integer size){

        Pageable pageable = PageRequest.of(page, size);

        Page<Ticket> pageResult = abstractRepository.findAll(pageable);

        if(pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<>();
        }


    }

}
