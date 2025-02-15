package com.example.springhillel.api.controller;

import com.example.springhillel.api.service.AbstractService;
import com.example.springhillel.model.AbstractEntity;
import com.example.springhillel.model.dto.transfer.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public abstract class AbstractControllerImpl <E extends AbstractEntity, D, R extends AbstractService<E, D>> implements AbstractController<E, D>{

    @Autowired
    private R abstractService;

//    @Autowired
//    private AbstractService<E, D> abstractService;

    @Override
    public void save(@Validated(Validation.New.class) @Valid @RequestBody D d) {
        abstractService.save(d);
    }

    @Override
    public void update(@Validated(Validation.Update.class) @RequestBody E e) {
        abstractService.update(e);
    }

    @Override
    public List<E> getAll(){
        return abstractService.getAll();
    }

    @Override
    public void deleteById(long id) {
        abstractService.deleteById(id);
    }

    @Override
    public Optional<E> findById(long id) {
        return abstractService.findById(id);
    }

}
