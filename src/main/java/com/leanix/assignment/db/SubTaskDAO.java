package com.leanix.assignment.db;

import java.util.List;

import com.leanix.assignment.core.SubTask;
import org.hibernate.SessionFactory;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class SubTaskDAO extends AbstractDAO<SubTask> {
    public SubTaskDAO(SessionFactory factory) {
        super(factory);
    }

    public SubTask create(SubTask subTask) {
        return persist(subTask);
    }

    public Optional<SubTask> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public List<SubTask> findAll() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<SubTask> criteria = builder.createQuery(SubTask.class);
        criteria.from(SubTask.class);
        List<SubTask> tasks = currentSession().createQuery(criteria).getResultList();
        return tasks;
    }

    public void update(SubTask subTask) {
        this.currentSession().update(SubTask.class.getName(), subTask);
    }

    public void delete(SubTask subTask) {
        this.currentSession().delete(SubTask.class.getName(), subTask);
    }

}
