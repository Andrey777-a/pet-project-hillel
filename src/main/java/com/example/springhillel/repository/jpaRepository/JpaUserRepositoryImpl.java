package com.example.springhillel.repository.jpaRepository;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        TypedQuery<User> userList = entityManager.createQuery("from User", User.class);
            for (User user: userList.getResultList()){
                System.out.println(user.toString());
            }
        return userList.getResultList();
    }

    @Override
    public void create(UserDTO user) {

        entityManager.persist(user);
       /* entityManager.createNativeQuery("INSERT INTO user (first_name, last_name, email, password, role_id) VALUES (?,?,?,?,?)")
                .setParameter(1, user.getFirstName())
                .setParameter(2, user.getLastName())
                .setParameter(3, user.getEmail())
                .setParameter(4, user.getPassword())
                .setParameter(5, user.getRoleId())
                .executeUpdate();*/
            }

    @Override
    public void deleted(int userId) {

        User user = entityManager.find(User.class, userId);

         entityManager.remove(user);

    }

    @Override
    public User findUserById(int userId) {
        String query = "SELECT u FROM User u where id = :userId";
        Query managerQuery = entityManager.createQuery(query);
        managerQuery.setParameter("userId", userId);
        return (User) managerQuery.getSingleResult();
    }

}
