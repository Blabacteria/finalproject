package com.web.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "TO-touring");
		return "Home";
	}
	@RequestMapping("/editor")
	public String editorhome(Model model) {
		model.addAttribute("title", "TO-touring");
		return "editorhomepage";
	}
	@RequestMapping("/editorpackage")
	public String editorpackage(Model model) {
		model.addAttribute("title", "TO-touring");
		return "editorpackage";
	}
	@RequestMapping("/editorviews")
	public String editorviews(Model model) {
		model.addAttribute("title", "TO-touring");
		return "editorviews";
	}
}
