package com.example.springhillel.repository.jparepository;

import com.example.springhillel.model.entity.Role;
import com.example.springhillel.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaRoleRepositoryImpl implements RoleRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void createRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void addActionPontToRole(int roleId, int actionId){
        entityManager.createNativeQuery("INSERT INTO role_action_point (role_id, action_point_id) VALUES (?,?)")
                .setParameter(1, roleId)
                .setParameter(2, actionId)
                .executeUpdate();
    }

    @Override
    public void roleAssignment(long userId, long roleId) {

        Role role = entityManager.find(Role.class, roleId);
        User user = entityManager.find(User.class, userId);

        user.setRole(role);

        entityManager.persist(user);

    }

    @Override
    public void deleteRole(long id) {

        Role role = entityManager.find(Role.class, id);

        entityManager.remove(role);

    }

    @Override
    public List<Role> getActionPointRole() {

        TypedQuery<Role> actionPointTypedQuery = entityManager.createQuery("select r from Role r", Role.class);

        return actionPointTypedQuery.getResultList();
    }

}
