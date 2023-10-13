package com.lmg.persistence;

import org.hibernate.boot.MetadataSources;

public class Database {

    public Database () {
        MetadataSources sources = new MetadataSources();
            sources.addAnnotatedClassName("com.lmg.models.pojos.User");
            sources.addResource("hibernate.cfg.xml");
    }
}
