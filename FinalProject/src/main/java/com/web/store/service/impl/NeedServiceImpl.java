package com.web.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.store.dao.NeedDao;
import com.web.store.model.NeedBean;
import com.web.store.model.TripBean;
import com.web.store.service.NeedService;


@Service
public class NeedServiceImpl implements NeedService {
	
	@Autowired
	NeedDao dao;
	
	@Transactional
	@Override
	public void insertNeedService(NeedBean bb) {
		dao.insertNeedDao(bb);
		
	}
	@Override
	@Transactional
	public List<TripBean> GetAllTogetherService() {
		List<TripBean> list = dao.getAllTogetherDao();
		return list;
	}
//	@Override
//	@Transactional
//	public List<TripBean> FilterTripService(TripBean bean) {
//		List<TripBean> list = dao.FilterTripDao(bean);
//		return list;
//	}
	@Override
	@Transactional
	public List<TripBean> FilterTripService(String tripname, String triptype, String countrycity, Integer tripdays,
			Integer lowestprice) {
		List<TripBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		String regex2 =  "^[0-9]+$";
		String lowestpriceString = String.valueOf(lowestprice);
		Integer tripnamecorrect = 0;
		Integer countrycitycorrect = 0;
		Integer lowestpricecorrect = 0;
		if(tripname!="") {
			boolean tripnameboolean = tripname.matches(regex1);
			if(tripnameboolean) {
				tripnamecorrect = 1;
				System.out.println("tripnamecorrect set = " + tripnamecorrect );
			}
		}else {
			tripnamecorrect = 1;
		}
		if(countrycity!="") {
			boolean countrycityboolean = countrycity.matches(regex1);
			if(countrycityboolean) {
				countrycitycorrect = 1;
				System.out.println("countrycitycorrect set = " + countrycitycorrect );
			}
		}else {
			countrycitycorrect = 1;
		}
		if(lowestprice!=null) {
		boolean lowestpriceboolean = lowestpriceString.matches(regex2);
			if(lowestpriceboolean) {
				lowestpricecorrect = 1;
				System.out.println("lowestpricecorrect set = " + lowestpricecorrect );
			}
		}else {
			lowestpricecorrect = 1;
		}
		if(tripnamecorrect==1 && countrycitycorrect==1 && lowestpricecorrect==1) {
			list = dao.FilterTripDao(tripname,triptype,countrycity,tripdays,lowestprice);
		}else {
			list = null;
		}
		
			System.out.println("Service NOT NULL");
		
			return list;

	}

}
