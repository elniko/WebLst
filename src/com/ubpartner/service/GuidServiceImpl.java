package com.ubpartner.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ubpartner.dao.IGuidDao;
import com.ubpartner.dto.ClientDto;
import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.Client;
import com.ubpartner.entity.Guid;
import com.ubpartner.entity.GuidPk;


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
	@Transactional(readOnly = true)
	public List<GuidDto> getAllGuids() {
		List<Guid> guids = dao.getAll();
		List<GuidDto> guidsDto = new ArrayList<GuidDto>();
		for(Guid guid : guids) {
			guidsDto.add(mappToDto(guid));
		}
		return guidsDto;
	}

	@Override
	@Transactional(readOnly = true)
	public GuidDto getById(GuidPk pk) {
		Guid g = dao.getById(pk);
		return mappToDto(g);
	}

	
	
	@Override
	@Transactional(readOnly = true)
	public GuidDto getById(String guid, String tool, String version) {
		Guid g = dao.getById(guid, tool, version);
		return mappToDto(g);
	}
	
	private GuidDto mappToDto(Guid g) {
		GuidDto gDto = new GuidDto();
		gDto.setActivations(g.getActivations());
		gDto.setApi(g.getApi());
		gDto.setCheating(g.getCheating());
		gDto.setCreatedAt(g.getCreatedAt());
		gDto.setEndDate(g.getEndDate());
		gDto.setEndXvt(g.getEndXvt());
		gDto.setIsNew(g.getIsNew());
		gDto.setOldGuid(g.getOldGuid());
		gDto.setPeriod(g.getPeriod());
		gDto.setPeriodXvt(g.getPeriodXvt());
		gDto.setPrimaryKey(g.getPrimaryKey());
		gDto.setSignature(g.getSignature());
		gDto.setStartDate(g.getStartDate()); 
		gDto.setWithXvt(g.getWithXvt());

		Client cli = g.getClient();
		ClientDto cDto = new ClientDto();
		cDto.setClient(cli.getClient());
		cDto.setCreatedAt(cli.getCreatedAt());
		cDto.setId(cli.getId());
		cDto.setUser(cli.getUser());

		gDto.setClient(cDto);
		return gDto;
	}

}
