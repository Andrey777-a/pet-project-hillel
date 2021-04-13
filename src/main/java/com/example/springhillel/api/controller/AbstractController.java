package com.example.springhillel.api.controller;

import com.example.springhillel.model.AbstractEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface AbstractController <E extends AbstractEntity, D> {

    @PostMapping
    void save(@RequestBody D d);

    @PutMapping
    void update(@RequestBody E e);

    @GetMapping
    List<E> getAll();

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable long id);

    @GetMapping("/{id}")
    Optional<E> findById(@PathVariable long id);

}
