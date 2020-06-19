# Todos

How to start the Todos application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/todo-application-0.0.1.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`


Output
________

[Fri Jun 19 09:22]~/Sites/dropwizard-todos$ java -jar target/todo-application-0.0.1.jar server config.yml 
INFO  [2020-06-19 03:52:52,567] io.dropwizard.server.DefaultServerFactory: Registering jersey handler with root path prefix: /
INFO  [2020-06-19 03:52:52,570] io.dropwizard.server.DefaultServerFactory: Registering admin handler with root path prefix: /
INFO  [2020-06-19 03:52:52,642] org.hibernate.Version: HHH000412: Hibernate ORM core version [WORKING]
INFO  [2020-06-19 03:52:52,774] io.dropwizard.hibernate.SessionFactoryFactory: Entity classes: [com.leanix.assignment.core.SubTask, com.leanix.assignment.core.Task]
INFO  [2020-06-19 03:52:52,792] org.hibernate.annotations.common.Version: HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
INFO  [2020-06-19 03:52:53,078] org.hibernate.dialect.Dialect: HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL10Dialect
INFO  [2020-06-19 03:52:53,690] io.dropwizard.server.ServerFactory: Starting Todos
================================================================================

                              Todos

================================================================================

INFO  [2020-06-19 03:52:53,767] org.eclipse.jetty.setuid.SetUIDListener: Opened application@365cef67{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
INFO  [2020-06-19 03:52:53,767] org.eclipse.jetty.setuid.SetUIDListener: Opened admin@27df5806{HTTP/1.1, (http/1.1)}{0.0.0.0:8081}
INFO  [2020-06-19 03:52:53,769] org.eclipse.jetty.server.Server: jetty-9.4.29.v20200521; built: 2020-05-21T17:20:40.598Z; git: 77c232aed8a45c818fd27232278d9f95a021095e; jvm 12.0.2+10
INFO  [2020-06-19 03:52:54,235] io.dropwizard.jersey.DropwizardResourceConfig: The following paths were found for the configured resources:

    GET     /hello (com.leanix.assignment.resources.HelloResource)
    GET     /todos (com.leanix.assignment.resources.TodoResource)
    POST    /todos (com.leanix.assignment.resources.TodoResource)
    DELETE  /todos/{id} (com.leanix.assignment.resources.TodoResource)
    GET     /todos/{id} (com.leanix.assignment.resources.TodoResource)
    PUT     /todos/{id} (com.leanix.assignment.resources.TodoResource)

INFO  [2020-06-19 03:52:54,237] org.eclipse.jetty.server.handler.ContextHandler: Started i.d.j.MutableServletContextHandler@6e668322{/,null,AVAILABLE}
INFO  [2020-06-19 03:52:54,241] io.dropwizard.setup.AdminEnvironment: tasks = 

    POST    /tasks/log-level (io.dropwizard.servlets.tasks.LogConfigurationTask)
    POST    /tasks/gc (io.dropwizard.servlets.tasks.GarbageCollectionTask)

INFO  [2020-06-19 03:52:54,245] org.eclipse.jetty.server.handler.ContextHandler: Started i.d.j.MutableServletContextHandler@949d347{/,null,AVAILABLE}
INFO  [2020-06-19 03:52:54,256] org.eclipse.jetty.server.AbstractConnector: Started application@365cef67{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
INFO  [2020-06-19 03:52:54,259] org.eclipse.jetty.server.AbstractConnector: Started admin@27df5806{HTTP/1.1, (http/1.1)}{0.0.0.0:8081}
INFO  [2020-06-19 03:52:54,259] org.eclipse.jetty.server.Server: Started @2847ms

