package com.smart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SmartController {
    
	@RequestMapping (value = "/home" , method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	
	@RequestMapping (value = "/galerie" , method = RequestMethod.GET)
	public String galerie() {
		
		return "work";
	}
	
	@RequestMapping (value = "/nouvelles" , method = RequestMethod.GET)
	public String nouvelles () {
		
		return "about";
	
   }
	
	@RequestMapping (value = "/articles" , method = RequestMethod.GET)
	public String articles () {
		
		return "blog";
	}
	
	@RequestMapping (value = "/contact" , method = RequestMethod.GET)
	public String contact () {
		
		return "contact";
	}
	
	@RequestMapping (value = "/panier" , method = RequestMethod.GET)
	public String panier () {
		
		return "services";
	}
	
	
}