package com.leanix.assignment.db;

import java.util.Optional;

import com.leanix.assignment.core.Task;
import org.hibernate.SessionFactory;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class TodosDAO extends AbstractDAO<Task> {

    public TodosDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Task create(Task task) {
        return persist(task);
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public List<Task> getAll() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Task> criteria = builder.createQuery(Task.class);
        criteria.from(Task.class);
        List<Task> tasks = currentSession().createQuery(criteria).getResultList();
        return tasks;
    }

    public void update(Task task) {
        this.currentSession().update(Task.class.getName(), task);
    }

    public void delete(Task task) {
        this.currentSession().delete(Task.class.getName(), task);
    }
}
