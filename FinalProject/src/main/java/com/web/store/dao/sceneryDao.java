package com.web.store.dao;

import java.util.List;


import com.web.store.model.SceneryBean;

public interface sceneryDao {
	List<SceneryBean> getAllProducts();
	public SceneryBean getViewById(int viewid);
	void addScenery(SceneryBean view);
}
