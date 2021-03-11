package com.smart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
	 
	     articles.put("source.jpeg", new BigDecimal(30000));
	     
	     articles.put("mamafrica.jpeg", new BigDecimal(50000));
	     
	     articles.put("bantuculture.jpeg", new BigDecimal(90000));
	     
	     
	     articles.put("blackp.jpeg", new BigDecimal(150000));
		 
	     articles.put("mystic.jpeg", new BigDecimal(100000));
	     articles.put("inspiration.jpeg", new BigDecimal(120000));
		 
	     articles.put("uzuri.jpeg", new BigDecimal(500));
	     
	     
	     articles.put("fruit.jpeg", new BigDecimal(80000));
		 
	     articles.put("kimia.jpeg", new BigDecimal(1500));
	     
	     
	     articles.put("celebration.jpeg", new BigDecimal(10000));
		 
	     articles.put("racines.jpeg", new BigDecimal(5000));
	      
	 }
	 
	 
	 private static String merchantID = "GA0100006";
	 private static String returnUrl ="https://smart100.herokuapp.com/";
	 
	
	@RequestMapping (value = "/home" , method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	
	
	
	@RequestMapping (value = "/" , method = RequestMethod.GET)
	public String homeBis() {
		
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
	public String detail(@RequestParam String article ,@RequestParam String nomArticle , final ModelMap model ) {
		
		LOG.info("La valeur de article est :"+article);
		
		model.addAttribute("nomArticle",nomArticle);
		model.addAttribute("path", "peintures/"+article);
		model.addAttribute("article", article);
		model.addAttribute("price", articles.get(article)+"€");
		
		
		model.addAttribute("merchantID", merchantID);
		model.addAttribute("uniqueID", UUID.randomUUID().toString());
		model.addAttribute("description","Achat de l'oeuvre"+ nomArticle);
		model.addAttribute("returnUrl", returnUrl);
		model.addAttribute("amount",  articles.get(article).multiply(new BigDecimal(657)));
		
		
		return "detail";
	}
	

}