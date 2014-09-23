package com.ubpartner.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ubpartner.dto.ClientDto;
import com.ubpartner.dto.GuidDto;
import com.ubpartner.entity.Client;
import com.ubpartner.entity.Guid;
import com.ubpartner.entity.GuidPk;

public class GuidDaoImpl extends HibernateDaoSupport implements IGuidDao {

	@Override
	public void save(Guid guid) {
		getHibernateTemplate().save(guid);

	}

	@Override
	public List<Guid> getAll() {
		
		return	getHibernateTemplate().loadAll(Guid.class);
		
//		Session session = getSessionFactory().openSession();
//		Criteria criteria = session.createCriteria(Guid.class);
//		List<Guid> guidList = (List<Guid>) criteria.list();
//		List<GuidDto> gDtoList = new ArrayList<GuidDto>();
//		for (Guid guid : guidList) {
//			gDtoList.add(mappToDto(guid));
//		}
//		session.close();
//		return gDtoList;
	}


	
	@Override
	public Guid getById(String guid, String tool, String version) {
		GuidPk pk = new GuidPk(guid, tool, version);
		return getById(pk);
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

	
	
	@Override
	public Guid getById(GuidPk pk) {
		return getHibernateTemplate().get(Guid.class, pk);
	}

}
