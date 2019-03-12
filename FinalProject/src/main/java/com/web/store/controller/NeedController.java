package com.web.store.controller;



import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.model.NeedBean;
import com.web.store.model.TripBean;
import com.web.store.service.NeedService;

@Controller
public class NeedController {
		@Autowired
		NeedService service;
		
		@Autowired
		ServletContext context;
		
		@RequestMapping(value="/selectNeed",method = RequestMethod.GET)
		public String NeedForm(Model model) {
			NeedBean bb = new NeedBean();
			model.addAttribute("insertneed", bb);
			System.out.println("Need空白表單");
			return "Needs";
		}
		@InitBinder
		public void whiteListing(WebDataBinder binder) {
		    binder.setAllowedFields(
		    "requiredPeople", 
		    "DepartureTime", 
		    "ComebackTime", 
		    "budget", 
		    "CustomDemand", 
		    "deadline" ,
		    "whetherFull",
		    "NoPayGoOrNot"
		    );
		}
		@RequestMapping(value="/selectNeed",method=RequestMethod.POST)
		public String Need(@ModelAttribute("insertneed") NeedBean bb ,BindingResult result,
				HttpServletRequest request) {
			String[] suppressedFields = result.getSuppressedFields();
			if (suppressedFields.length > 0) {
				throw new RuntimeException("嘗試傳入不允許的欄位: " + 
			    StringUtils.arrayToCommaDelimitedString(suppressedFields));
			}
			System.out.println("需求人數" + bb.getRequiredPeople() + 
					"預算" + bb.getBudget()
					+ "自訂需求" + bb.getCustomDemand()
					+ "出發時間" + bb.getDepartureTime()
					+ "回程時間" + bb.getComebackTime()
					+ "揪團期限" + bb.getDeadline()
					+ "未付款出團" + bb.getNoPayGoOrNot()
					+ "未滿人出團" + bb.getWhetherFull());
			service.insertNeedService(bb);
			return "redirect:/";
		}
	
		@RequestMapping("/GetTogether")
		public String GetAllTogether(Model model){
			System.out.println("GetTogether");
			List<TripBean> list = service.GetAllTogetherService();
			model.addAttribute("Together", list);
			return "Together";			
		}
		//篩選
//		@RequestMapping(value="/Filter",method=RequestMethod.GET)
//		public String FilterTripForm(Model model) {
//			TripBean bb = new TripBean();
//			model.addAttribute("filterTrip", bb);
//			System.out.println("Trip空白表單");
//			return "Together";
//		}
//		@RequestMapping(value="/Filter",method=RequestMethod.POST)
//		public String FilterTrip(@ModelAttribute("filterTrip") TripBean bb ,
//				HttpServletRequest request ,Model model) {
//				System.out.println("行程名稱 " + bb.getTripname() + "分類  " +bb.getTriptype() + 
//						"國家  " + bb.getCountrycity() + "天數 " +bb.getTripdays() + "最低開銷 " + bb.getLowestprice() 
//						);
//				List<TripBean> list = service.FilterTripService(bb);
//				model.addAttribute("Together", list);
//			return "Together";
//		}
		
		@RequestMapping(value="/Filter" ,method=RequestMethod.POST)
		public String FilterTrip(@RequestParam("tripname")String tripname,@RequestParam("triptype")String triptype,
				@RequestParam("countrycity")String countrycity,@RequestParam("tripdays")Integer tripdays,
				@RequestParam("lowestprice")Integer lowestprice,Model model) {
			
			System.out.println(tripname+triptype+countrycity+tripdays+lowestprice);
			List<TripBean> list = service.FilterTripService(tripname, triptype, countrycity, tripdays, lowestprice);
			model.addAttribute("formtext", tripname);
			model.addAttribute("formtext1", triptype);
			model.addAttribute("formtext2", countrycity);
			model.addAttribute("formtext3", tripdays);
			model.addAttribute("formtext4", lowestprice);
			model.addAttribute("formtext5", tripdays);
			
			if(list==null) {
				model.addAttribute("error", "不可輸入特殊符號!!");
				List<TripBean> list1 = service.GetAllTogetherService();
				model.addAttribute("Together", list1);
			}else {
			model.addAttribute("Together", list);
			}
			return "Together";
		}
}
