package id.ac.campus.spring.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="table_hero", schema="public")
public class TblHero {

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	@Column(name="hero_id", unique=true, nullable=false)
	private String heroId;
	
	@Column(name="hero_code")
	private Integer heroCode;
	
	@Column(name="hero_name")
	private String heroName;
	
	@Column(name="hero_role")
	private String heroRole;
	
	@Column(name="hero_specialities")
	private String heroSpecialities;
	
	@Column(name="hero_laning")
	private String heroLaning;
	
	@Column(name="hero_release_year")
	private String heroReleaseYear;
	
	@Column(name="hero_battle_point")
	private BigDecimal heroBattlePoint;
	
	@Column(name="hero_diamond")
	private BigDecimal heroDiamond;

	public TblHero() {
		
	}
	
	public String getHeroId() {
		return heroId;
	}

	public void setHeroId(String heroId) {
		this.heroId = heroId;
	}

	public Integer getHeroCode() {
		return heroCode;
	}

	public void setHeroCode(Integer heroCode) {
		this.heroCode = heroCode;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getHeroRole() {
		return heroRole;
	}

	public void setHeroRole(String heroRole) {
		this.heroRole = heroRole;
	}

	public String getHeroSpecialities() {
		return heroSpecialities;
	}

	public void setHeroSpecialities(String heroSpecialities) {
		this.heroSpecialities = heroSpecialities;
	}

	public String getHeroLaning() {
		return heroLaning;
	}

	public void setHeroLaning(String heroLaning) {
		this.heroLaning = heroLaning;
	}

	public String getHeroReleaseYear() {
		return heroReleaseYear;
	}

	public void setHeroReleaseYear(String heroReleaseYear) {
		this.heroReleaseYear = heroReleaseYear;
	}

	public BigDecimal getHeroBattlePoint() {
		return heroBattlePoint;
	}

	public void setHeroBattlePoint(BigDecimal heroBattlePoint) {
		this.heroBattlePoint = heroBattlePoint;
	}

	public BigDecimal getHeroDiamond() {
		return heroDiamond;
	}

	public void setHeroDiamond(BigDecimal heroDiamond) {
		this.heroDiamond = heroDiamond;
	}
	
}
