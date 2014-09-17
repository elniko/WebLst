package com.ubpartner.dao;

import java.util.List;

import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.GuidPk;

public interface IGuidDao {
	
	public void save(GuidDto guid);
	
	public List<GuidDto> getAll();
	
	public GuidDto getById(String guid, String tool, String version);
	
	public GuidDto getById(GuidPk pk);
	

}
