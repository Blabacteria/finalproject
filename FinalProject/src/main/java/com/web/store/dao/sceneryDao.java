package com.web.store.dao;

import java.util.List;


import com.web.store.model.SceneryBean;

public interface sceneryDao {
	List<SceneryBean> getAllProducts();
	public SceneryBean getViewById(int viewid);
	void addScenery(SceneryBean view);
	List<SceneryBean>FilterCountrySceneryDao(String country);
	List<SceneryBean>FilterCitySceneryDao(String city);
	List<SceneryBean>FilterCountryCitySceneryDao(String country,String city);
}
