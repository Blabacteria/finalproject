package com.web.store.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.web.store.model.SceneryBean;

public interface sceneryService {
List<SceneryBean> getAllProducts();
public SceneryBean getViewById(int viewid);
void addScenery(SceneryBean view);
}
