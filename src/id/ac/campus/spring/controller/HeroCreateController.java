package id.ac.campus.spring.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.ac.campus.spring.entity.TblHero;
import id.ac.campus.spring.service.HeroDaoService;

@Controller
public class HeroCreateController {

	@Autowired
	private HeroDaoService heroDaoService;
	
	@RequestMapping("/hero-create")
	public String heroCreate(@RequestParam(required=false) String validationMessage,
			ModelMap modelMap) {
		
		if (validationMessage != null) {
			modelMap.put("validationMessage", validationMessage);
		}
		
		return "hero-create";
	}
	
	@RequestMapping("/hero-save-todb")
	public String heroSave(@RequestParam(required=false) Integer heroCode,
			@RequestParam(required=false) String heroName,
			@RequestParam(required=false) String heroRole,
			@RequestParam(required=false) String heroSpecialities,
			@RequestParam(required=false) String heroLaning,
			@RequestParam(required=false) String heroReleaseYear,
			@RequestParam(required=false) BigDecimal heroBattlePoint,
			@RequestParam(required=false) BigDecimal heroDiamond,
			ModelMap modelMap) {
		
		// 0. Validate empty or zero input check
		if (heroCode == 0 || heroName.isEmpty() || heroRole.isEmpty()) {
			modelMap.addAttribute("validationMessage", "Hero Code or Hero Name or Hero Role cannot be empty!");
			return "redirect:/hero-create";
		}
		
		// 0. Validate duplicate from database
		TblHero recordHeroCode = heroDaoService.findByHeroCode(heroCode);
		if (recordHeroCode != null) {
			modelMap.addAttribute("validationMessage", "Hero Code: " + heroCode + " is already exist!");
			return "redirect:/hero-create";
		}
		
		// 1. Initial new Table Hero
		TblHero tblHero = new TblHero();
		
		// 2. Set ID - UUID (PK)
		tblHero.setHeroId(UUID.randomUUID().toString());
		
		// 3. Set Data
		tblHero.setHeroCode(heroCode);
		tblHero.setHeroName(heroName);
		tblHero.setHeroRole(heroRole);
		tblHero.setHeroSpecialities(heroSpecialities);
		tblHero.setHeroLaning(heroLaning);
		tblHero.setHeroReleaseYear(heroReleaseYear);
		tblHero.setHeroBattlePoint(heroBattlePoint);
		tblHero.setHeroDiamond(heroDiamond);
		
		// 4. Send data to DAO Service for Insert new data
		heroDaoService.insertData(tblHero);
		
		// Redirect Hero List Page
		return "redirect:/hero-list";
	}
	
}
