package com.ubpartner.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.ubpartner.entity.Guid;
import com.ubpartner.entity.GuidPk;




public class GuidModel extends Model{
	
	
	public GuidModel() {
		super();
	}

	@Override
	public Object getById(Object id) throws Exception {
	        Object guid = null;  	 
		    try {
		      createSession();
		      guid = session.load(Guid.class, (GuidPk) id);
		    } catch (Exception e) {
 	    	  throw new Exception("Error getById:Guid");
		    } finally {
		    	closeSession();
		    }
		    return guid;
		
	}
	
	
	public Guid getById(String sguid, String tool, String version ) {
		Guid guid = null;  
		
		  createSession();
	     GuidPk id = new GuidPk(sguid, tool, version);
	      
	      guid = (Guid)session.load(Guid.class,  id);
	      closeSession();
	      
//	    try {
//	      createSession();
//	    //  Guid.GuidPk id = new Guid.GuidPk(sguid, tool, version);
//	      guid = session.load(Guid.class,  id);
//	    } catch (Exception e) {
//	      //throw new Exception("Error getById:Guid");
//	    } finally {
//	    	closeSession();
//	    }
	    return guid;
	}

	@Override
	public void saveEntity(Object entity) throws Exception {
		
		    try {
		      createSession();
		      session.beginTransaction();
		      session.save((Guid) entity);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		    	throw new Exception("Error saveEntity:Guid" + e.getMessage());
		    } finally {
		    	closeSession();
		    }
		
	}

	@Override
	public List<Object> getAll() throws Exception {
		    List<Object> guids = null;
		    try {
		      createSession();
		      guids = session.createCriteria(Guid.class).list();
		    } catch (Exception e) {
		    	throw new Exception("Error getAll:Guid");
		    } finally {
		    	closeSession();
		    }
		return guids;
	}

	@Override
	public List<Object> getByField(String field, Object value) throws Exception {
	
		    List guids = null;
		    try {
		      createSession();
		      session.beginTransaction();
		      Query query = session.createQuery(" SELECT g FROM Guid  g WHERE " + field +" = :value ");
		      if (value instanceof Boolean) {
		    	  query.setBoolean("value", (Boolean) value);
		      } else if (value instanceof String) {
		    	  query.setString("value", (String) value);
		      } else if (value instanceof Integer) {
		    	  query.setInteger("value",  (Integer) value);
		      }
		      guids = (List<Object>) query.list();

		    } catch (Exception e){
		    	throw new Exception("Error getByField:Guid");
		    } finally {
		    	closeSession();
		    }
		return guids;
	}
	
	
	public List<Object> getToolVersions() throws Exception {
		 List result = null;
		    try {
		      createSession();
		      session.beginTransaction();
		      
		      Query query = session.createSQLQuery("SELECT DISTINCT * FROM guids GROUP BY product, version").addEntity(Guid.class);
		      
		      
		      
		     // Criteria criteria = session.createCriteria(GuidPk.class);
		      //ProjectionList projectionList = Projections.projectionList();
              
            //  projectionList.add(Projections.groupProperty("version"));

              //criteria.setProjection(projectionList);
              result = query.list();

		    } catch (Exception e){
		    	throw new Exception("Error getByField:Guid " + e.getMessage());
		    } finally {
		    	closeSession();
		    }
		return result;
	}

	@Override
	public void updateRecord(Object entity) throws Exception {
		  try {
			  createSession();
		      session.beginTransaction();
		      session.update((Guid) entity);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		    	throw new Exception("Error updateRecord:Guid");
		    } finally {
		    	closeSession();
		    }
		
	}

	@Override
	public void deleteRecord(Object obj) throws Exception {
		 try {
			  Guid guid = null;
			  createSession();
		      session.beginTransaction();
		      if (obj instanceof GuidPk) {
		         guid = (Guid) getById(obj);
		      } else {
		    	 guid = (Guid) obj;
		      }
		      session.delete(guid);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		    	throw new Exception("Error deleteRecord:Guid");
		    } finally {
		    	closeSession();
		    }
		
	}

}
