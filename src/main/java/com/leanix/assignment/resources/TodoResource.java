package com.leanix.assignment.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.util.Optional;


import javax.ws.rs.core.MediaType;
import com.leanix.assignment.core.SubTask;
import com.leanix.assignment.db.SubTaskDAO;
import io.dropwizard.hibernate.UnitOfWork;
import com.leanix.assignment.core.Task;

import java.util.List;
import java.util.logging.Logger;

import com.leanix.assignment.db.TodosDAO;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodosDAO todosDAO;
    private final SubTaskDAO subTaskDAO;

    public TodoResource(TodosDAO todosDAO, SubTaskDAO subTaskDAO) {
        this.todosDAO = todosDAO;
        this.subTaskDAO = subTaskDAO;
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Task createTask(Task task) {
        Task newTask = todosDAO.create(task);
        for (SubTask subTask: task.getSubTasks()) {
            subTask.setTask(newTask);
            subTaskDAO.create(subTask);
        }
        return newTask;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Task> getTask(@PathParam("id") Long id) {
        return todosDAO.findById(id);
    }

    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> listTasks() {
        return todosDAO.getAll();
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Task> updateTask(@PathParam("id") Long id, Task task) {
        task.setId(id);
        todosDAO.update(task);
        for (SubTask subTask: task.getSubTasks()) {
            subTask.setTask(task);
            subTaskDAO.update(subTask);
        }
        return todosDAO.findById(task.getId());
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void deleteTask(@PathParam("id") Long id) {
        Optional<Task> task = todosDAO.findById(id);
        if (task.isPresent()) {
            todosDAO.delete(task.get());
        }
    }

}
