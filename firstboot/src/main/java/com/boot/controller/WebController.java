package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.model.Nation;
import com.boot.repositories.NationRepository;

@Controller
public class WebController {
	@Autowired
	NationRepository nations;

	@RequestMapping("/hello.do")
	public String firstRequest() {
		return "first";
	}
	
	@RequestMapping("/cities.do")
	public String cities(ModelMap map) {
		map.addAttribute("countries", (List<Nation>)nations.findAll());
		return "cities";
		
	}
}
