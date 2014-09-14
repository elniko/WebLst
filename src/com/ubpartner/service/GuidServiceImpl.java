package com.ubpartner.service;

import java.util.List;

import com.ubpartner.dao.IGuidDao;
import com.ubpartner.entity.Guid;

public class GuidServiceImpl implements IGuidService{

	
	IGuidDao dao;
	public void setDao(IGuidDao dao)
    {
	        this.dao = dao;
    }
	
	@Override
	public void saveGid(Guid guid) {
		dao.save(guid);
		
	}

	 
	
	@Override
	public List<Guid> getAllGuids() {
		
		return dao.getAll();
	}

}
