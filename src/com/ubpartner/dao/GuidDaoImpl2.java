package com.ubpartner.dao;

import org.hibernate.SessionFactory;

import com.ubpartner.entity.Guid;
import com.ubpartner.entity.GuidPk;

public class GuidDaoImpl2 extends AbstractHibernateDao<Guid, GuidPk> {

	public void setSessionFactory(SessionFactory factory) {
		sessionFactory = factory;
	}

}
