package com.ubpartner.service;

import java.util.List;

import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.GuidPk;

public interface IGuidService {
   public void saveGid(GuidDto guid);
   
   public List<GuidDto> getAllGuids();
   
   public GuidDto getById(GuidPk pk);
   
   public GuidDto getById(String guid, String tool, String version);
   
}
