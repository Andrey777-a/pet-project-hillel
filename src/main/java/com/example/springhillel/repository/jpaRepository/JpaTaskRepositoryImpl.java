package com.example.springhillel.repository.jpaRepository;

import com.example.springhillel.model.dto.TaskAttributeDTO;
import com.example.springhillel.model.entity.StatusTask;
import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.model.entity.TypeTask;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class JpaTaskRepositoryImpl implements TaskRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<TaskAttribute> getAllTask() {
        TypedQuery<TaskAttribute> taskAttribute = entityManager.createQuery("select u from TaskAttribute u", TaskAttribute.class);

        return taskAttribute.getResultList();
    }

    @Override
    public void createTask(TaskAttributeDTO taskAttributeDTO) {

        User user = entityManager.find(User.class, taskAttributeDTO.getAssignee());
        StatusTask statusTask = entityManager.find(StatusTask.class, taskAttributeDTO.getStatus());
        TypeTask typeTask = entityManager.find(TypeTask.class, taskAttributeDTO.getTypeTask());

        TaskAttribute taskAttribute = new TaskAttribute(taskAttributeDTO.getName(), taskAttributeDTO.getDescription(),
                user, statusTask, taskAttributeDTO.getPriority(), taskAttributeDTO.getTimeSpent(),
                taskAttributeDTO.getTimeEstimated(), taskAttributeDTO.getCreatedOnDate(), typeTask);

        entityManager.persist(taskAttribute);

    }

    @Override
    public void updateTask(TaskAttribute taskAttribute) {

        entityManager.persist(taskAttribute);

    }

    @Override
    public List<TaskAttribute> getTaskUser(int user) {

        TypedQuery<TaskAttribute> taskAttributeTypedQuery = entityManager.createQuery("select t from TaskAttribute t", TaskAttribute.class);

        for (TaskAttribute taskAttribute: taskAttributeTypedQuery.getResultList()){
            System.out.println(taskAttribute.toString());
        }

        return taskAttributeTypedQuery.getResultList();
    }

    @Override
    public TaskAttribute getTask(long id) {

        return entityManager.find(TaskAttribute.class, id);
    }

    @Override
    public void deleteTask(long idTask) {

        TaskAttribute taskAttribute = entityManager.find(TaskAttribute.class, idTask);
        StatusTask statusTask = entityManager.find(StatusTask.class, 5L);

        taskAttribute.setStatus(statusTask);

        entityManager.persist(taskAttribute);
    }

}
