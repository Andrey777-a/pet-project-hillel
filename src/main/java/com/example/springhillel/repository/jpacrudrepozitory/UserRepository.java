package com.example.springhillel.repository.jpacrudrepozitory;

import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {
}
