package com.web.store.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="scenery")
public class SceneryBean {
	private Integer 	viewid ;
	private String  	name;
	private String  	address;
	private String 		country;
	private String 		city;
	private Integer		needticket; 		
	private Double      price;
	private Blob    	photo;	
	private String      introduction;
	private MultipartFile  viewImage;
	private String  	fileName;
	public SceneryBean() {
	}
	public SceneryBean(Integer viewid, String name, String address, String country, String city, Integer needticket,
			double price, Blob photo, String introduction) {
		this.viewid = viewid;
		this.name = name;
		this.address = address;
		this.country = country;
		this.city = city;
		this.needticket = needticket;
		this.price = price;
		this.photo = photo;
		this.introduction = introduction;
	}
    @Transient
    public MultipartFile getviewImage() {
    	return viewImage;
    }

    public void setviewImage(MultipartFile viewImage) {
    	this.viewImage = viewImage;
    }
	public void setViewid(Integer viewid) {
		this.viewid = viewid;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getViewid() {
		return viewid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getNeedticket() {
		return needticket;
	}
	
	public void setNeedticket(Integer needticket) {
		this.needticket = needticket;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Blob getPhoto() {
		return photo;
	}
	
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
