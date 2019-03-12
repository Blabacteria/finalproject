package com.web.store.service;

import java.util.List;

import com.web.store.model.NeedBean;
import com.web.store.model.TripBean;


public interface NeedService {
	void insertNeedService(NeedBean bb);
	List<TripBean> GetAllTogetherService();
//	List<TripBean> FilterTripService(TripBean bean);
	List<TripBean> FilterTripService(String tripname,String triptype,String countrycity,Integer tripdays,Integer lowestprice);
}
