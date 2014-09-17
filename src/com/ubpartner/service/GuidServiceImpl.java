package com.ubpartner.service;

import java.util.List;

import com.ubpartner.dao.IGuidDao;
import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.GuidPk;


public class GuidServiceImpl implements IGuidService{

	
	IGuidDao dao;
	public void setDao(IGuidDao dao)
    {
	        this.dao = dao;
    }
	
	@Override
	public void saveGid(GuidDto guid) {
		dao.save(guid);
		
	}

	 
	
	@Override
	public List<GuidDto> getAllGuids() {
		
		return dao.getAll();
	}

	@Override
	public GuidDto getById(GuidPk pk) {

		return dao.getById(pk);
	}

	@Override
	public GuidDto getById(String guid, String tool, String version) {
		return dao.getById(guid, tool, version);
	}

}
