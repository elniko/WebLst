package com.ubpartner.webresources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ubpartner.entity.Guid;
import com.ubpartner.exception.GidNotFoundException;
import com.ubpartner.model.EntityManager;
import com.ubpartner.model.GuidModel;

@Path("/guids")
public class WebGidManagement {
	private GuidModel guidModel = (GuidModel) EntityManager.getModel("guid");
	
	@GET
	@Path("/getlic/{guid}/{tool}/{version}")
	@Produces(MediaType.APPLICATION_XML)
	public Guid getLicence(@PathParam("guid") String guid, @PathParam("tool") String tool, @PathParam("version") String version) throws GidNotFoundException {
		
		Guid guidObj =  guidModel.getById(guid, tool, version);
		
		if(guidObj == null) {
			throw new GidNotFoundException("Guid not found", guid, tool, version);
		}
		
		
		return guidObj;
		//return Response.ok(new ResponseHolder(guidObj)).build();
	}
	
	
	
}
