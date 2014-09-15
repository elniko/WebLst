package com.ubpartner.dao;

import java.util.List;

import com.ubpartner.entity.Guid;

public interface IGuidDao {
	
	public void save(Guid guid);
	
	public List<Guid> getAll();
	
	public Guid getById(String guid, String tool, String version);
	
	public Guid getById(Guid.GuidPk pk);
	

}
