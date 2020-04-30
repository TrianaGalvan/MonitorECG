/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author trianaandaluciaprietogalvan
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();
    
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
    	
        try {
            sessionFactory = new MetadataSources( serviceRegistry )
                    .buildMetadata().buildSessionFactory();
        } catch(Exception e) {
            // The registry would be destroyed by the SessionFactory, 
            // but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( serviceRegistry );
            e.printStackTrace();
        }
        
        return sessionFactory;
    }
}
