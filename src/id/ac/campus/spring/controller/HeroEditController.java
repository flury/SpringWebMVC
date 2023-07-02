package id.ac.campus.spring.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.campus.spring.entity.TblHero;
import id.ac.campus.spring.service.HeroDaoService;

@Controller
public class HeroEditController {

	@Autowired
	HeroDaoService heroDaoService;
	
	// A.
	@RequestMapping("/hero-edit/{id}")
	public String heroEdit(@PathVariable String id, ModelMap modelMap) {
		
		// 1. Find Hero by ID
		TblHero tblHero = heroDaoService.findByID(id);
		
		// 2. Set data to JSP/View Edit
		modelMap.addAttribute("tblHeroView", tblHero);
		
		// Display to Hero Edit Page
		return "hero-edit";
	}
	
	// B.
	@RequestMapping("/hero-update-todb")
	public String heroUpdate(@RequestParam(required=false) String heroId,
			@RequestParam(required=false) String heroRole,
			@RequestParam(required=false) String heroSpecialities,
			@RequestParam(required=false) String heroLaning,
			@RequestParam(required=false) String heroReleaseYear,
			@RequestParam(required=false) BigDecimal heroBattlePoint,
			@RequestParam(required=false) BigDecimal heroDiamond) {
		
		// 1. Find Hero By ID
		TblHero tblHero = heroDaoService.findByID(heroId);
		
		// 2. Set Data Update
		tblHero.setHeroRole(heroRole);
		tblHero.setHeroSpecialities(heroSpecialities);
		tblHero.setHeroLaning(heroLaning);
		tblHero.setHeroReleaseYear(heroReleaseYear);
		tblHero.setHeroBattlePoint(heroBattlePoint);
		tblHero.setHeroDiamond(heroDiamond);
		
		// 3. Send data to DAO Service
		heroDaoService.updateData(tblHero);
		
		// Redirect to Hero List Page
		return "redirect:/hero-list";
	}
	
}
