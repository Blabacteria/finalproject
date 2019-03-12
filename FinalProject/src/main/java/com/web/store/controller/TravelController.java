package com.web.store.controller;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.model.SceneryBean;

import com.web.store.service.sceneryService;

@Controller
public class TravelController {
	
	@Autowired
	sceneryService service;
	
	@Autowired
	ServletContext context;
	
	String day ;
	String title1;
	@RequestMapping(value="join.do")
	public String toJoin(@RequestParam("title") String title, @RequestParam("days") String days, Model model) {
		model.addAttribute("packagetitle", title);
		day = days;
		title1=title;
		model.addAttribute("day",days+"天");
		model.addAttribute("days", days);		
		return "/editorpackage" ;
	}	
	@RequestMapping(value="/Filter1" ,method=RequestMethod.POST)
	public String FilterScenery(@RequestParam("country") String country, @RequestParam("city") String city, Model model) {
		List<SceneryBean> list = service.FilterCountryService(country);
		List<SceneryBean> list1 = service.FilterCityService(city);
		List<SceneryBean> list2 = service.getAllProducts();
		List<SceneryBean> list3 = service.FilterCountryCitySceneryDao(country, city);
		Integer listnull = 0;
		Integer list1null = 0;
		model.addAttribute("country",country);
		model.addAttribute("city",city);
		model.addAttribute("days", day);
		model.addAttribute("day", day+"天");
		model.addAttribute("packagetitle",title1);
		if(list == null) {
			model.addAttribute("error", "不可輸入特殊符號!!");						
		}else {
			listnull = 1;
		}
		if(list1 == null) {
			model.addAttribute("error", "不可輸入特殊符號!!");
		}else {
			list1null = 1;
		}
		if(listnull == 1 && list1null == 1) {
			model.addAttribute("Views",list3);
		}else if(listnull == 1 && list1null == 0){
			model.addAttribute("Views",list);
		}else if(listnull == 0 && list1null == 1) {
			model.addAttribute("Views", list1);
		}else {
			model.addAttribute("Views", list2);
		}
		return "/editorpackage";		
	}
	
}
	