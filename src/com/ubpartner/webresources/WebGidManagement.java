package com.ubpartner.webresources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.TestEntity;
import com.ubpartner.exception.GidNotFoundException;
import com.ubpartner.model.EntityManager;
import com.ubpartner.model.GuidModel;
import com.ubpartner.service.IGuidService;

@Path("/guids")
public class WebGidManagement {
	private GuidModel guidModel = (GuidModel) EntityManager.getModel("guid");
	
	@GET
	public void test() {
	
	}
	
	
	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public List<GuidDto> getLicenses() {

		   ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	       IGuidService service = (IGuidService) ctx.getBean("guidService");
	       List<GuidDto> guids = service.getAllGuids();
	       return guids;
	}
	
	@GET
	@Path("/getlic/{guid}/{tool}/{version}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public GuidDto getLicence(@PathParam("guid") String guid, @PathParam("tool") String tool, @PathParam("version") String version) throws GidNotFoundException {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    IGuidService service = (IGuidService) ctx.getBean("guidServiceImpl2");
	    GuidDto guidObj =  service.getById(guid, tool, version);
		
		if(guidObj == null) {
			throw new GidNotFoundException("Guid not found", guid, tool, version);
		}
		
		return guidObj;
	}
	
	
	
}
