package com.ubpartner.model;

import java.util.List;

import org.hibernate.Session;

public abstract class Model {

	protected Session session;
	
	public Model(){
		createSession();
	}

	public Session getSession() {
		return session;
	}
	
	public void createSession(){
		//session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public void closeSession() {
		if (session != null && session.isOpen()) {
	        session.close();
	      }
	}
	
	
	public abstract Object getById (Object id) throws Exception;
	
	public abstract void saveEntity (Object entity) throws Exception;
	
	public abstract List<Object> getAll() throws Exception;
	
	public abstract List<Object> getByField(String field, Object value) throws Exception;
	
	public abstract void updateRecord(Object obj) throws Exception;
	
	public abstract void deleteRecord(Object id) throws Exception;
	
}
