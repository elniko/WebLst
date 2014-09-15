package com.ubpartner.service;

import java.util.List;

import com.ubpartner.entity.Guid;

public interface IGuidService {
   public void saveGid(Guid guid);
   
   public List<Guid> getAllGuids();
   
   public Guid getById(Guid.GuidPk pk);
   
   public Guid getById(String guid, String tool, String version);
   
}
