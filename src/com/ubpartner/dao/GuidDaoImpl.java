package com.ubpartner.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ubpartner.entity.Guid;
import com.ubpartner.entity.Guid.GuidPk;

public class GuidDaoImpl extends HibernateDaoSupport implements IGuidDao {

	@Override
	public void save(Guid guid) {
		getHibernateTemplate().save(guid);
		
	}

	@Override
	public List<Guid> getAll() {
		return getHibernateTemplate().loadAll(Guid.class);
	}

	@Override
	public Guid getById(String guid, String tool, String version) {
		
		Guid.GuidPk pk = new GuidPk(guid, tool, version);
		
		return getById(pk) ;
	}

	@Override
	public Guid getById(GuidPk pk) {

		
		return getHibernateTemplate().get(Guid.class, pk);
	}

}
