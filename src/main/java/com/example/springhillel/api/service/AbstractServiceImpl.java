package com.example.springhillel.api.service;

import com.example.springhillel.api.service.crudservice.convert.AbstractConvert;
import com.example.springhillel.exception.NotFoundException;
import com.example.springhillel.model.AbstractEntity;
import com.example.springhillel.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class AbstractServiceImpl <E extends AbstractEntity, D, R extends AbstractRepository<E>> implements AbstractService<E, D>{

    @Autowired
    private R abstractRepository;
//
//    @Autowired
//    private AbstractRepository<E> abstractRepository;

    @Autowired
    private AbstractConvert<E, D> abstractConvert;

    @Override
    @Transactional
    public void save(D d){
        abstractRepository.save(abstractConvert.convertToEntity(d));
    }

    @Override
    @Transactional
    public void update(E e) {
        valid(e.getId());
        abstractRepository.save(e);
    }

    @Override
    @Transactional(readOnly = true)
    public List<E> getAll() {
        return (List<E>) abstractRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        valid(id);
        abstractRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<E> findById(long id) {

        valid(id);
        return abstractRepository.findById(id);
    }



    private void valid(long id){
        Optional<E> optional = abstractRepository.findById(id);

        if(optional.isEmpty()){
            throw new NotFoundException("Entity not found");
        }
    }
}
