package com.judgeandresolve.backendrest.dao.impl;

import com.judgeandresolve.backendrest.dao.interfaces.TaskDAO;
import com.judgeandresolve.backendrest.models.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TaskDAOImpl implements TaskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> getTasks() {
        String query = "FROM Task";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void createTask(Task task) {
        entityManager.merge(task);
    }
}
