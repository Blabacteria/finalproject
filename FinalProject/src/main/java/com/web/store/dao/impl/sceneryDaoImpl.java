package com.web.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.sceneryDao;

import com.web.store.model.SceneryBean;
@Repository
public class sceneryDaoImpl implements sceneryDao {

	@Autowired
	SessionFactory factory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SceneryBean> getAllProducts() {
		String hql = "FROM SceneryBean";
		Session session = null;
		List<SceneryBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void addScenery(SceneryBean view) {
		Session session = factory.getCurrentSession();
		session.save(view);
	}

	@Override
	public SceneryBean getViewById(int viewid) {
		Session session = factory.getCurrentSession();
		SceneryBean sc = session.get(SceneryBean.class, viewid);
		return sc;
	}

}
