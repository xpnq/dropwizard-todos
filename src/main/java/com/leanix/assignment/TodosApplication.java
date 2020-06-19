package com.leanix.assignment;

import com.leanix.assignment.core.SubTask;
import com.leanix.assignment.core.Task;
import com.leanix.assignment.db.SubTaskDAO;
import com.leanix.assignment.db.TodosDAO;
import com.leanix.assignment.resources.HelloResource;
import com.leanix.assignment.resources.TodoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import org.jdbi.v3.core.Jdbi;

public class TodosApplication extends Application<TodosConfiguration> {

    private final HibernateBundle<TodosConfiguration> hibernateBundle = new HibernateBundle<TodosConfiguration>(Task.class, SubTask.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(TodosConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };


    public static void main(final String[] args) throws Exception {
        new TodosApplication().run(args);
    }

    @Override
    public String getName() {
        return "Todos";
    }

    @Override
    public void initialize(final Bootstrap<TodosConfiguration> bootstrap) {
            bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final TodosConfiguration configuration,
                    final Environment environment) {

        final TodosDAO todosDAO
                = new TodosDAO(hibernateBundle.getSessionFactory());
        final SubTaskDAO subTaskDAO = new SubTaskDAO(hibernateBundle.getSessionFactory());

        environment.jersey().register(new TodoResource(todosDAO, subTaskDAO));

        environment.jersey().register(new HelloResource());
    }

}
