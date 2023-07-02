package id.ac.campus.spring.service;

import java.util.List;

import id.ac.campus.spring.entity.TblHero;

public interface HeroDaoService {

	// Find All Data
	public List<TblHero> findAll();
	
	// Insert New Data Hero
	public void insertData(TblHero tblHero);
	
	// Find Data Hero By ID
	public TblHero findByID(String id);
	
	// Update Data Hero
	public void updateData(TblHero tblHero);
	
	// Delete Data Hero
	public void deleteData(TblHero tblHero);
	
	// Check duplicate by HeroCode
	public TblHero findByHeroCode(Integer heroCode);
	
}
