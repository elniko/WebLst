package com.ubpartner.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractHibernateDao< T extends Serializable, PK extends Serializable> {
	 
	   private Class< T > clazz;
	 
	   protected SessionFactory sessionFactory;
	 
	   public final void setClazz(Class< T > clazzToSet){
	      this.clazz = clazzToSet;
	   }
	 
	   public T findOne(PK id){
	      return (T) sessionFactory.getCurrentSession().get(clazz, id);
	   }
	   
	   public List< T > findAll(){
	      return sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list();
	   }
	 
	   public void create( T entity ){
		   sessionFactory.getCurrentSession().persist(entity);
	   }
	 
	   public void update( T entity ){
		   sessionFactory.getCurrentSession().merge(entity);
	   }
	 
	   public void delete(T entity){
		   sessionFactory.getCurrentSession().delete(entity);
	   }
	   public void deleteById(PK entityId){
	      T entity = findOne(entityId);
	      delete(entity);
	   }
	 
	   protected final Session getCurrentSession(){
	      return sessionFactory.getCurrentSession();
	   }
	}