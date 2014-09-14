package com.ubpartner.dao;

import java.util.List;

import com.ubpartner.entity.Guid;

public interface IGuidDao {
	
	public void save(Guid guid);
	
	public List<Guid> getAll();
	
	

}
