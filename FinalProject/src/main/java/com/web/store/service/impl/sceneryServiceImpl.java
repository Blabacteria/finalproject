package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.sceneryDao;
import com.web.store.model.SceneryBean;
import com.web.store.model.TripBean;
import com.web.store.service.sceneryService;
@Service
public class sceneryServiceImpl implements sceneryService {   
	@Autowired
	sceneryDao dao;
	
	@Override
	@Transactional
	public List<SceneryBean> getAllProducts() {
		
		return dao.getAllProducts();
	}
	@Override
	@Transactional
	public void addScenery(SceneryBean view) {
		dao.addScenery(view);
	}
	@Override
	@Transactional
	public SceneryBean getViewById(int viewid) {		
		return dao.getViewById(viewid);
	}
	@Override
	@Transactional
	public List<SceneryBean> FilterCountryService(String country) {
		List<SceneryBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer countrynamecorrect = 0;
		if(country !="") {
			boolean countrynameboolean = country.matches(regex1);
			if(countrynameboolean) {
				countrynamecorrect = 1;
			}
		}else {
			countrynamecorrect = 1;
		}
		if(countrynamecorrect == 1) {
		list= dao.FilterCountrySceneryDao(country);
		}else {
			list = null;
		}
		return list;
	}
	@Override
	@Transactional
	public List<SceneryBean> FilterCityService(String city) {
		List<SceneryBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer citynamecorrect = 0;
		if(city !="") {
			boolean citynameboolean = city.matches(regex1);
			if(citynameboolean) {
				citynamecorrect = 1;
			}
		}else {
			citynamecorrect = 1;
		}
		if(citynamecorrect == 1) {
		list= dao.FilterCitySceneryDao(city);
		}else {
			list = null;
		}
		return list;
	}
	@Override
	@Transactional
	public List<SceneryBean> FilterCountryCitySceneryDao(String country, String city) {
		List<SceneryBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer countrynamecorrect = 0;
		Integer citynamecorrect = 0;
		if(country !="") {
			boolean countrynameboolean = country.matches(regex1);
			if(countrynameboolean) {
				countrynamecorrect = 1;
			}
		}else {
			countrynamecorrect = 1;
		}
		if(city !="") {
			boolean citynameboolean = city.matches(regex1);
			if(citynameboolean) {
				citynamecorrect = 1;
			}
		}else {
			citynamecorrect = 1;
		}
		if(citynamecorrect == 1 && countrynamecorrect == 1) {
			list= dao.FilterCountryCitySceneryDao(country, city);
			}else {
				list = null;
			}
		return list;
	}
	@Override
	@Transactional
	public List<String> SelectCountryCitySceneryDao(String country) {
		List<String> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer countrynamecorrect = 0;
		if(country !="") {
			boolean countrynameboolean = country.matches(regex1);
			if(countrynameboolean) {
				countrynamecorrect = 1;
			}
		}else {
			countrynamecorrect = 1;
		}
		if(countrynamecorrect == 1) {
		list= dao.SelectCountryCitySceneryDao(country);
		}else {
			list = null;
		}
		return list;
	}
	@Override
	@Transactional
	public List<String> SelectCityDao(String city) {
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		List<String> selcity;
		Integer citynamecorrect = 0;
		if(city !="") {
			boolean citynameboolean = city.matches(regex1);
			if(citynameboolean) {
				citynamecorrect = 1;
			}
		}else {
			citynamecorrect = 1;
		}
		if(citynamecorrect == 1) {
		selcity = dao.SelectCityDao(city);
		}else {
			selcity = null;
		}
		return selcity;
	}
	@Transactional
	@Override
	public SceneryBean getViewByName(String viewname) {		
		return dao.getViewByName(viewname);
	}

}
