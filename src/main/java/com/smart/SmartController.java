package com.smart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmartController {
    
	 private static final Logger LOG = LoggerFactory.getLogger(SmartController.class);
	 
	 
	 Map<String , BigDecimal> articles = new HashMap<>();
	 
	 {
		 articles.put("kitoko.jpeg", new BigDecimal(1000));
		 
		 
	 }
	 
	
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
		
		return "new";
	
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
		
		return "detail";
	}
	
	
	@RequestMapping (value = "/detail" , method = RequestMethod.POST)
	public String detail(@RequestParam String article , final ModelMap model ) {
		
		LOG.info("La valeur de article est :"+article);
		
		model.addAttribute("article", "peintures/"+article);
		model.addAttribute("price", articles.get(article)+"€");
		return "detail";
	}
	
	
}