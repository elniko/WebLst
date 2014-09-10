package com.ubpartner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.ubpartner.entity.Client;



public class ClientModel extends Model {
	
	
	private HashMap<String, ArrayList<Client>> usersList = new HashMap<String, ArrayList<Client>>();
	private HashMap<String, Integer> clientIds = new HashMap<String, Integer>();
	private ArrayList<User> clients = new  ArrayList<User>();  
	
	public ClientModel() {
		super();
	}

	@Override
	public Object getById(Object id) throws Exception {
	        Object client = null;  	 
		    try {
		      createSession();
		      client = session.load(Client.class, (Integer) id);
		     
		    } catch (Exception e) {
 	    	  throw new Exception("Error getById:Client");
		    } finally {
		    	closeSession();
		    }
		    return client;
		
	}
	
	

	@Override
	public void saveEntity(Object entity) throws Exception {
		
		    try {
		      createSession();
		      session.beginTransaction();
		      session.save((Client) entity);
		      session.getTransaction().commit();
		      
		    } catch (Exception e) {
		    	throw new Exception("Error saveEntity:Client");
		    } finally {
		    	closeSession();
		    }
		
	}

	@Override
	public List<Object> getAll() throws Exception {
		    List<Object> clients = null;
		    try {
		      createSession();
		      clients = session.createCriteria(Client.class).list();
		      
		    } catch (Exception e) {
		    	throw new Exception("Error getAll:Client");
		    } finally {
		    	closeSession();
		    }
		return clients;
	}

	@Override
	public List<Object> getByField(String field, Object value) throws Exception {
	
		    List clients = null;
		    try {
		      createSession();
		      session.beginTransaction();
		      Query query = session.createQuery(" SELECT c FROM Client  c WHERE " + field +" = :value ");
		      if (value instanceof Boolean) {
		    	  query.setBoolean("value", (Boolean) value);
		      } else if (value instanceof String) {
		    	  query.setString("value", (String) value);
		      } else if (value instanceof Long) {
		    	  query.setLong("value", (Long) value);
		      }
		      clients = (List<Object>) query.list();

		    } catch (Exception e){
		    	throw new Exception("Error getByField:Client");
		    } finally {
		    	closeSession();
		    }
		return clients;
	}

	@Override
	public void updateRecord(Object entity) throws Exception {
		  try {
			  createSession();
		      session.beginTransaction();
		      session.update((Client) entity);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		    	throw new Exception("Error updateRecord:Client " + e.getMessage());
		    } finally {
		    	closeSession();
		    }
		
	}

	@Override
	public void deleteRecord(Object obj) throws Exception {
		 try {
			  Client client = null;
			  createSession();
		      session.beginTransaction();
		      if (obj instanceof Client) {
		    	 client = (Client) obj;
		      } else {
		    	 client = (Client) getById(obj);
		    	  
		      }
		      session.delete(client);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		    	throw new Exception("Error deleteRecord:Client");
		    } finally {
		    	closeSession();
		    }
		
	}
	
	public void getAllClients() throws Exception{
		
		List<Object> list = getAll();
		Iterator<Object> it = list.iterator();
		usersList.clear();
		clientIds.clear();
		while (it.hasNext()) {
			Client cli = (Client) it.next();
			String clientName = cli.getClient();
			String userName = cli.getUser();
			int id = cli.getId();
			//User user = new User(id, userName);
		    
			if (userName.equals("")) {
				clientIds.put(clientName, id);
			}
			
			
			if (usersList.containsKey(clientName)) {
				ArrayList<Client> users = usersList.get(clientName);
				
				if (!containsUser(users, cli)) {
				  users.add(cli);
				}
			} else {
				ArrayList<Client> users = new ArrayList<Client>();
				if (!users.contains(cli)) {
					  users.add(cli);
				}
				usersList.put(clientName, users);
			}
			
		}
		
		
		
	}
	
	private boolean containsUser(ArrayList<Client> users , Client user) {
		for (Client us : users) {
			if (us.getUser().equals(user.getUser())) {
				return true;
			}
		}
		return false;
	}

  
	public Set<String> getClients() throws Exception {
		
		    getAllClients();
			return usersList.keySet();
		
	}
	
	public ArrayList<Client> getUsers(String client, boolean update) throws Exception {
		 ArrayList<Client> result = new ArrayList<Client>(); 
			try {
				if (usersList == null || update) {
					getAllClients();
				}
				if (usersList.containsKey(client)) {
					return  usersList.get(client);
					
				} else {
					return null;
				}
			} catch (Exception e) {
				throw new Exception("Error getUsers");
			}
		
	}
	
	public HashMap<String, Integer> getNewClients() throws Exception {
		try {
			if (usersList == null) {
				getAllClients();
			}
			return clientIds;
		} catch (Exception e) {
			throw new Exception("Error getUsers");
		}
	
	}
	
	
	
	public static class User {
		private String name;
		private int id;
		
		public User (int id, String name) {
			setId(id);
			setName(name);
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
	}
	
	public static class UClient<UClient> implements Comparable<UClient> {
		private String name;
		private int id;
		
		public UClient(int id, String name) {
			setId(id);
			setName(name);
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		

		

		@Override
		public int compareTo(UClient o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
}
