package id.ac.campus.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.campus.spring.entity.TblHero;
import id.ac.campus.spring.service.HeroDaoService;

@Controller
public class HeroController {

	@Autowired
	private HeroDaoService heroDaoService;
	
	@RequestMapping("/hero-list")
	public String heroList(ModelMap modelMap) {
		
		List<TblHero> listTableHero = heroDaoService.findAll();
		
		modelMap.addAttribute("listTableHero", listTableHero);
		
		return "hero-list";
	}
}
