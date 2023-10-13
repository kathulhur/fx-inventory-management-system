package com.lmg;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.lmg.models.ModelFactory;
import com.lmg.models.pojos.User;
import com.lmg.viewmodels.ViewModelFactory;
import com.lmg.views.ViewHandler;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        setUp();
        testDatabase();

        ModelFactory mf = new ModelFactory();   
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(primaryStage, vmf);
        vh.start();
    }

    protected void setUp() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry =
            new StandardServiceRegistryBuilder()
                    .build();     
    try {
        sessionFactory =
                new MetadataSources(registry)             
                        .addAnnotatedClass(User.class)   
                        .buildMetadata()                  
                        .buildSessionFactory();           
    }
    catch (Exception e) {
        System.out.println("here!!!!");
        // The registry would be destroyed by the SessionFactory, but we
        // had trouble building the SessionFactory so destroy it manually.
        StandardServiceRegistryBuilder.destroy(registry);
    }
}

    public void testDatabase() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User("user", "password");
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }
}