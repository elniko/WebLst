package com.ubpartner.model;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 * Class for utilisation Hibernate.
 *
 */
public final class HibernateUtil {

    /**
     * Constructor of class.
     */
    private HibernateUtil() {
    }

    /**
     * SessionFactory connecting to Hibernate.
     *
     */
    private static final SessionFactory sessionFactory;

    static {
       try {
    	   
    	   //Configuration cfg = new Configuration();
    	   //cfg.configure();
    	   //sessionFactory = cfg.buildSessionFactory(new ServiceRegistryBuilder().applySettings(cfg.getProperties()).getBootstrapServiceRegistry());
    	   
    	   Configuration configuration = new Configuration().configure();
    	  	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
    	  	applySettings(configuration.getProperties());
    	  	sessionFactory = configuration.buildSessionFactory(builder.build());
    	 
          //sessionFactory = new Configuration().configure().buildSessionFactory();
       } catch (Throwable ex) {
            //System.err.println("Initial SessionFactory creation failed." + ex);
    	   ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
       }
    }

    /**
     * SessionFactory getter method.
     *
     * @return sessionfactory.
     *
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
