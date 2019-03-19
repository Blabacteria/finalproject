package com.web.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.sceneryDao;

import com.web.store.model.SceneryBean;
import com.web.store.model.TripBean;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<SceneryBean> FilterCountrySceneryDao(String country) {
		Session session = factory.getCurrentSession();
		List<SceneryBean>list = new ArrayList<SceneryBean>();
		String hql = "From SceneryBean ";
		if(country == "") {
			hql += "where country LIKE" +" country";
		}else {
			hql +=  "where country LIKE" + " '%" +country +"%'" ;
		}
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SceneryBean> FilterCitySceneryDao(String city) {
		Session session = factory.getCurrentSession();
		List<SceneryBean>list = new ArrayList<SceneryBean>();
		String hql = "From SceneryBean ";
		if(city == "") {
			hql += "where city LIKE" +" city";
		}else {
			hql +=  "where city LIKE" + " '%" +city +"%'";
		}
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SceneryBean> FilterCountryCitySceneryDao(String country, String city) {
		Session session = factory.getCurrentSession();
		List<SceneryBean>list = new ArrayList<SceneryBean>();
		String hql = "From SceneryBean " ;
		if(country == "") {
			hql += "where country LIKE" +" country";
		}else {
			hql +=  "where country LIKE" + " '%" +country +"%'" ;
		}
		if(city == "") {
			hql += " AND city LIKE" +" city";
		}else {
			hql +=  " AND city LIKE" + " '%" +city +"%'" ;
		}
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> SelectCountryCitySceneryDao(String country) {
		Session session = factory.getCurrentSession();
		List<String> list = new ArrayList<String>();
		String hql = "SELECT DISTINCT city From SceneryBean " ;
		if(country == "") {
			hql += "where country LIKE" +" country";
		}else {
			hql +=  "where country LIKE" + " '%" +country +"%'" ;
		}
		list = session.createQuery(hql).getResultList();
		System.out.println(list);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> SelectCityDao(String city) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT DISTINCT city From SceneryBean ";
		if(city == "") {
			hql += "where city LIKE" +" city";
		}else {
			hql +=  "where city LIKE" + " '%" +city +"%'";
		}
		List<String> selcity =session.createQuery(hql).getResultList();
		return selcity;
	}

	@Override
	public SceneryBean getViewByName(String viewname) {
		Session session = factory.getCurrentSession();
		String hql = "From SceneryBean where name =:viewname";
		SceneryBean sc = (SceneryBean) session.createQuery(hql).setParameter("viewname", viewname).getSingleResult();
		return sc;
	}
}
