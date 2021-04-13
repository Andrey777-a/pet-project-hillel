package com.example.springhillel.api.service;

import com.example.springhillel.model.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface AbstractService <E extends AbstractEntity, D> {

    void save(D d);

    void update(E e);

    List<E> getAll();

    void deleteById(long id);

    Optional<E> findById(long id);


}
