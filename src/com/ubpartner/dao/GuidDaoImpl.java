package com.ubpartner.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ubpartner.entity.Guid;

public class GuidDaoImpl extends HibernateDaoSupport implements IGuidDao {

	@Override
	public void save(Guid guid) {
		getHibernateTemplate().save(guid);
		
	}

	@Override
	public List<Guid> getAll() {
		return getHibernateTemplate().loadAll(Guid.class);
	}

}
