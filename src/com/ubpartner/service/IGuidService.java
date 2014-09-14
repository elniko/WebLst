package com.ubpartner.service;

import java.util.List;

import com.ubpartner.entity.Guid;

public interface IGuidService {
   public void saveGid(Guid guid);
   
   public List<Guid> getAllGuids();
   
}
