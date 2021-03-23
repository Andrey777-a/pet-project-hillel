package com.example.springhillel.repository.jpaRepository;

import com.example.springhillel.model.entity.Role;
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
    public void roleAssignment(int userId, int roleId) {


        entityManager.createNativeQuery("UPDATE user set role_id = ? where id = ?")
                .setParameter(1, userId)
                .setParameter(2, roleId)
                .executeUpdate();
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
