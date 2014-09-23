package com.ubpartner.dao;

import java.util.List;

import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.Guid;
import com.ubpartner.entity.GuidPk;

public interface IGuidDao {
	
	public void save(Guid guid);
	
	public List<Guid> getAll();
	
	public Guid getById(String guid, String tool, String version);
	
	public Guid getById(GuidPk pk);
	
	

}
