package com.ubpartner.service;

import java.util.ArrayList;
import java.util.List;

import com.ubpartner.dao.AbstractHibernateDao;
import com.ubpartner.dao.GuidDaoImpl2;
import com.ubpartner.dto.ClientDto;
import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.Client;
import com.ubpartner.entity.Guid;
import com.ubpartner.entity.GuidPk;

public class GuidServiceImpl2 implements IGuidService {
	
	GuidDaoImpl2 dao;
	public void setDao(GuidDaoImpl2  dao) {
		this.dao = dao;
	}
	
	@Override
	public void saveGid(Guid guid) {
		// TODO Auto-generated method stub
		
	}

	@MyAnnotation
	@Override
	public List<GuidDto> getAllGuids() {
		// TODO Auto-generated method stub
		List<Guid> guids = dao.findAll();
		List<GuidDto> res = new ArrayList<GuidDto> ();
		for(Guid g : guids) {
			GuidDto gdto = mappToDto(g);
			res.add(gdto);
		}
		return res;
	}

	@Override
	public GuidDto getById(GuidPk pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuidDto getById(String guid, String tool, String version) {
		GuidPk pk = new GuidPk(guid, tool, version);
		Guid g = dao.findOne(pk);
		
		return mappToDto(g);
	}

	private GuidDto mappToDto(Guid g) {
		
		
		
		GuidDto gDto = new GuidDto();
		gDto.setActivations(g.getActivations());
		gDto.setApi(g.getApi());
		gDto.setCheating(g.getCheating());
		gDto.setCreatedAt(g.getCreatedAt());
		gDto.setEndDate(g.getEndDate());
		gDto.setEndXvt(g.getEndXvt());
		gDto.setIsNew(g.getIsNew());
		gDto.setOldGuid(g.getOldGuid());
		gDto.setPeriod(g.getPeriod());
		gDto.setPeriodXvt(g.getPeriodXvt());
		gDto.setPrimaryKey(g.getPrimaryKey());
		gDto.setSignature(g.getSignature());
		gDto.setStartDate(g.getStartDate()); 
		gDto.setWithXvt(g.getWithXvt());

		Client cli = g.getClient();
		ClientDto cDto = new ClientDto();
		cDto.setClient(cli.getClient());
		cDto.setCreatedAt(cli.getCreatedAt());
		cDto.setId(cli.getId());
		cDto.setUser(cli.getUser());

		gDto.setClient(cDto);
		return gDto;
	}
	
}
