package id.ac.campus.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.campus.spring.entity.TblHero;
import id.ac.campus.spring.service.HeroDaoService;

@Controller
public class HeroDeleteController {

	@Autowired
	private HeroDaoService heroDaoService;
	
	// Part 1
	@RequestMapping("/hero-delete/{id}")
	public String heroDelete(@PathVariable String id, ModelMap modelMap) {
		
		// 1. Find Hero by ID
		TblHero tblHero = heroDaoService.findByID(id);
		
		// 2. Set data to JSP/View Edit
		modelMap.addAttribute("tblHeroView", tblHero);
		
		return "hero-delete";
	}
	
	// Part 2
	@RequestMapping("/hero-delete-todb")
	public String heroDelete(@RequestParam(required=false) String heroId) {
		
		// 1. Find Hero by ID
		TblHero tblHero = heroDaoService.findByID(heroId);
		
		// 2. Execute delete
		heroDaoService.deleteData(tblHero);
		
		// Redirect to Hero List
		return "redirect:/hero-list";
	}
	
}
