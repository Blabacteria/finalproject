package com.web.store.dao;

import java.util.List;

import com.web.store.model.NeedBean;
import com.web.store.model.TripBean;





public interface NeedDao {
	void insertNeedDao(NeedBean bean);
	void updateNeedDao(NeedBean bean);
	List<NeedBean> selectNeedDao(String AccountId);
	List<TripBean>  getAllTogetherDao();
//	List<TripBean> FilterTripDao(TripBean bean);
	List<TripBean> FilterTripDao(String tripname,String triptype,String countrycity,Integer tripdays,Integer lowestprice);
}
