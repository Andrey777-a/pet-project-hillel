package com.example.springhillel.repository.jpaRepository;

import com.example.springhillel.model.entity.Role;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.RoleRepository;
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
    public void deleteRole(int id) {

        Role role = entityManager.find(Role.class, id);

        entityManager.remove(role);

    }

    @Override
    public List<Role> getActionPointRole() {

        TypedQuery<Role> actionPointTypedQuery = entityManager.createQuery("from Role", Role.class);

        return actionPointTypedQuery.getResultList();
    }

}
