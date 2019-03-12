package com.web.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.store.dao.NeedDao;
import com.web.store.model.NeedBean;
import com.web.store.model.TripBean;




@Repository
public class NeedDaoImpl implements NeedDao {
	@Autowired
	SessionFactory factory;
	
	@Override
	public void insertNeedDao(NeedBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);
		System.out.println("insert success!");
	}

	@Override
	public void updateNeedDao(NeedBean bean) {
		Session session = factory.getCurrentSession();
//		String hql = "FROM Need WHERE AcountId = :acountId";
		session.saveOrUpdate(bean);
		System.out.println("update success!");
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NeedBean> selectNeedDao(String AccountId) {
		Session session = factory.getCurrentSession();
		List<NeedBean> list = new ArrayList<NeedBean>();
		String hql = "FROM NeedBean WHERE AcountId =:acountid";
		list = session.createQuery(hql).setParameter("acountid", AccountId).getResultList();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TripBean> getAllTogetherDao() {
		Session session = factory.getCurrentSession();
		String hql = "FROM TripBean";
		List<TripBean> list = session.createQuery(hql).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TripBean> FilterTripDao(String tripname, String triptype, String countrycity, Integer tripdays,
			Integer lowestprice) {
		Session session = factory.getCurrentSession();
		List<TripBean> list = new ArrayList<TripBean>();
//		if(tripname!="" && triptype!="" && countrycity!=""&& lowestprice!=null && tripdays!=0) {
//			System.out.println("NOT NULL");
//			
//			String hql = "FROM TripBean WHERE  tripname LIKE:tripname" +"\n"+
//					"AND countrycity LIKE:countrycity" +"\n"+ 
//					"AND triptype =:triptype" + "\n" + 
//					"AND tripdays =:tripdays" + "\n" +
//					"AND lowestprice <=:lowestprice" ;
//			list = session.createQuery(hql).setParameter("tripname","%" +tripname+ "%").setParameter("countrycity", "%"+countrycity+"%")
//					.setParameter("countrycity","%"+countrycity +"%")
//					.setParameter("triptype",triptype)
//					.setParameter("tripdays",tripdays )
//					.setParameter("lowestprice",lowestprice).list();
//		}else if(tripname==""){
//			
//			System.out.println("tripname null");
//			String hql = "FROM TripBean WHERE countrycity LIKE:countrycity" +"\n"+ 
//					"AND triptype =:triptype" + "\n" + 
//					"AND tripdays =:tripdays" + "\n" +
//					"AND lowestprice <=:lowestprice" ;
//			list = session.createQuery(hql).setParameter("countrycity", "%"+countrycity+"%")
//					.setParameter("triptype",triptype)
//					.setParameter("tripdays",tripdays )
//					.setParameter("lowestprice",lowestprice).list();
//		}else if(countrycity=="") {
//			System.out.println("countrycity null");
//			
//			String hql = "FROM TripBean WHERE  tripname LIKE:tripname" +"\n"+
//					"AND triptype =:triptype" + "\n" + 
//					"AND tripdays =:tripdays" + "\n" +
//					"AND lowestprice <=:lowestprice" ;
//			list = session.createQuery(hql).setParameter("tripname","%" +tripname+ "%")
//					.setParameter("countrycity", "%"+countrycity+"%")
//					.setParameter("triptype",triptype)
//					.setParameter("tripdays",tripdays )
//					.setParameter("lowestprice",lowestprice).list();
//		}else if(lowestprice==null) {
//			System.out.println("lowestprice null");
//			String hql = "FROM TripBean WHERE  tripname LIKE:tripname" +"\n"+
//					"AND countrycity LIKE:countrycity" +"\n"+ 
//					"AND triptype =:triptype" + "\n" + 
//					"AND tripdays =:tripdays";
//			list = session.createQuery(hql).setParameter("tripname","%" +tripname+ "%")
//					.setParameter("countrycity", "%"+countrycity+"%")
//					.setParameter("triptype",triptype)
//					.setParameter("tripdays",tripdays ).list();
//		}else if(tripdays==0) {
//			
//			System.out.println("tripdays = 0");
//			String hql = "FROM TripBean WHERE  tripname LIKE:tripname" +"\n"+
//					"AND countrycity LIKE:countrycity" +"\n"+ 
//					"AND triptype =:triptype" + "\n" +
//					"AND lowestprice <=:lowestprice";
//
//			list = session.createQuery(hql).setParameter("tripname","%" +tripname+ "%")
//					.setParameter("countrycity", "%"+countrycity+"%")
//					.setParameter("triptype",triptype)
//					.setParameter("lowestprice",lowestprice).list();
//		}else {
//			
//			System.out.println("only one is not null");
//			String hql = "FROM TripBean WHERE  tripname LIKE:tripname" +"\n"+
//					"OR countrycity LIKE:countrycity" +"\n"+ 
//					"OR triptype =:triptype" + "\n" + 
//					"OR tripdays =:tripdays" + "\n" +
//					"OR lowestprice <=:lowestprice" ;
//			list = session.createQuery(hql).setParameter("tripname","%" +tripname+ "%")
//					.setParameter("countrycity","%"+countrycity +"%")
//					.setParameter("triptype",triptype)
//					.setParameter("tripdays",tripdays )
//					.setParameter("lowestprice",lowestprice).list();
//		}
		String hql = "FROM TripBean WHERE  "+
//				+ "tripname LIKE:tripname" +"\n"+
//				"AND countrycity LIKE:countrycity" +"\n"+ 
				" triptype =:triptype" + "\n"  ;
//				"AND tripdays =:tripdays" + "\n" +
//				"AND lowestprice <=:lowestprice" ;
			
			
		if(tripname=="") {
			hql +=  "AND tripname LIKE" +" tripname" +"\n";
//					
		}else {
//			tripname = "%" + tripname + "%";
			hql +=  "AND tripname LIKE" + " '%" +tripname +"%'" +"\n";
		}
		if(countrycity=="") {
			hql +=  "AND countrycity LIKE" +" countrycity" +"\n";
		}else {
//			countrycity = "%" + countrycity + "%";
			hql +=  "AND countrycity LIKE" +" '%" + countrycity+"%'" +"\n";
		}
		if(tripdays!=0) {
				hql += "AND tripdays ="+ tripdays + "\n";
		}
		if(lowestprice!=null) {
			hql += "AND lowestprice <="+lowestprice;
		}
		list = session.createQuery(hql).setParameter("triptype", triptype).list();
		
				
		return list;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<TripBean> FilterTripDao(TripBean bean) {
//		Session session = factory.getCurrentSession();
//		List<TripBean> list = new ArrayList<TripBean>();
//		String hql = "FROM TripBean WHERE  tripname LIKE:tripname" +
//										"AND countrycity LIKE:countrycity" + 
//										"AND triptype =:triptype" + 
//										"AND tripdays =:tripdays" + 
//										"AND lowestprice <=:lowestprice" ;
//		list = session.createQuery(hql).setParameter("tripname","%" + bean.getTripname() + "%").setParameter("countrycity","%"+ bean.getCountrycity()+"%")
//				.setParameter("triptype", bean.getTriptype()).setParameter("tripdays", bean.getTripdays()).setParameter("lowestprice",bean.getLowestprice())
//				.getResultList();
//		return list;
//	}

}
