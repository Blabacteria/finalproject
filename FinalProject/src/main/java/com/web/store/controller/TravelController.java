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

	@RequestMapping(value="/Filter1" ,method=RequestMethod.POST)
	public String FilterScenery(@RequestParam("title") String title, @RequestParam("days") String days, @RequestParam("country") String country, @RequestParam("city") String city, Model model) {
		List<SceneryBean> list = service.FilterCountryService(country);
		List<SceneryBean> list1 = service.FilterCityService(city);
		List<SceneryBean> list2 = service.getAllProducts();
		List<SceneryBean> list3 = service.FilterCountryCitySceneryDao(country, city);
		List<String> list4 = service.SelectCountryCitySceneryDao(country);
		List<String> selcity = service.SelectCityDao(city);
		model.addAttribute("country",country);
		model.addAttribute("city",city);
		model.addAttribute("days", days);
		model.addAttribute("day", days+"天");
		model.addAttribute("packagetitle",title);
		
		if(list == null) {
			model.addAttribute("error", "不可輸入特殊符號!!");						
		}else {
		
		}
		if(list1 == null) {
			model.addAttribute("error", "不可輸入特殊符號!!");
		}else {
			
		}
		if(country != "" && city != "") {
			model.addAttribute("view",selcity);
			model.addAttribute("Views",list3);
			System.out.println("1");
		}else if(country != ""  && city == ""){
			model.addAttribute("view",list4);
			model.addAttribute("Views",list);
			System.out.println("2");
		}else if(country == "" && city != "") {
			model.addAttribute("view",selcity);
			model.addAttribute("Views", list1);
			System.out.println("3");
		}else {
			model.addAttribute("view",list4);
			model.addAttribute("Views", list2);
			System.out.println("4");
		}
		return "/editorpackage";		
	}
	
}
	