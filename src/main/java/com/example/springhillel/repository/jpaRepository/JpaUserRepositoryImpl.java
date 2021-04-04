package com.example.springhillel.repository.jpaRepository;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.Role;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    /*public User findOne(){

        EntityGraph entityGraph =  entityManager.getEntityGraph("graph.User");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        User user = entityManager.find(User.class, 1L, properties);
        return user;
    }*/

//    @EntityGraph(value = "graph.User", type = EntityGraph.EntityGraphType.LOAD)
    @Override
    public List<User> getAll() {
        TypedQuery<User> userList = entityManager.createQuery("select u from User u", User.class);
            for (User user: userList.getResultList()){
                System.out.println(user.toString());
            }
        return userList.getResultList();
    }

    @Override
    public void create(UserDTO userDTO) {

        Role role = entityManager.find(Role.class, userDTO.getRoleId());

        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getPassword(),
                        userDTO.getEmail(), role);

        entityManager.persist(user);
    }

    @Override
    public void deleted(int userId) {

        User user = entityManager.find(User.class, userId);

         entityManager.remove(user);

    }

    @Override
    public User findUserById(long userId) {

        return entityManager.find(User.class, userId);
    }

}
