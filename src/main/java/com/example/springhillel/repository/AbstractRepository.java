package com.example.springhillel.repository;

import com.example.springhillel.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository <E extends AbstractEntity> extends JpaRepository<E, Long> {
}
