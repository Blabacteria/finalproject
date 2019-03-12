package com.web.store.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="trip")
public class TripBean {
	private Integer tripId;
	private String tripname;
	private Blob photo;
	private String triptype;
	private String countrycity;
	private Integer tripdays;
	private Integer lowestprice;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getTripname() {
		return tripname;
	}
	public void setTripname(String tripname) {
		this.tripname = tripname;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getTriptype() {
		return triptype;
	}
	public void setTriptype(String triptype) {
		this.triptype = triptype;
	}
	public String getCountrycity() {
		return countrycity;
	}
	public void setCountrycity(String countrycity) {
		this.countrycity = countrycity;
	}
	public Integer getTripdays() {
		return tripdays;
	}
	public void setTripdays(int tripdays) {
		this.tripdays = tripdays;
	}
	public Integer getLowestprice() {
		return lowestprice;
	}
	public void setLowestprice(Integer lowestprice) {
		this.lowestprice = lowestprice;
	}
	
}
