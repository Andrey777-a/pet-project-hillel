package com.example.springhillel.repository;

import com.example.springhillel.model.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository <E extends AbstractEntity> extends CrudRepository<E, Long> {
}
