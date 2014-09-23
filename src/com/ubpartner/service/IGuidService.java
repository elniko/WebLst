package com.ubpartner.service;

import java.util.List;

import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.Guid;
import com.ubpartner.entity.GuidPk;

public interface IGuidService {
   public void saveGid(Guid guid);
   
   public List<GuidDto> getAllGuids();
   
   public GuidDto getById(GuidPk pk);
   
   public GuidDto getById(String guid, String tool, String version);
   
  
}
