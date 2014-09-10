package com.ubpartner.model;

public  class EntityManager {
	
  private static GuidModel guidModel = null;
  private static ClientModel clientModel =null;
	
  public EntityManager() {
	
		  if (guidModel == null) {
			  guidModel = new GuidModel();
		  }
		  
		  if (clientModel == null) {
			  clientModel = new ClientModel(); 
		  }
		  
  }
  

  
  
  public static Model getModel(String model) {
	  if(model.toLowerCase().equals("guid")){
		  if (guidModel ==null) {
			  guidModel = new GuidModel();
		  }
		  return guidModel;
	  } else if (model.toLowerCase().equals("client")) {
		  if(clientModel == null) {
			  clientModel = new ClientModel(); 
		  }
		  
		  return clientModel;
	  }
	  return null;
  }
  
  
  
  
}
