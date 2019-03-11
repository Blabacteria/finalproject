package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.sceneryDao;
import com.web.store.model.SceneryBean;
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

}
