package com.example.springhillel.api.controller.pagination;

import com.example.springhillel.api.service.pagination.PaginationService;
import com.example.springhillel.model.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagination")
public class PaginationController {

    @Autowired
    private PaginationService paginationService;

    @GetMapping
    public List<Ticket> getAllTicket(@RequestParam("page") Integer page, @RequestParam("size")
            Integer size){
        return paginationService.getAllTicket(page, size);
    }

}
