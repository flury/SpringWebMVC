package id.ac.campus.spring.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.ac.campus.spring.entity.TblHero;

@Service
@Transactional
public class HeroDaoServiceImpl implements HeroDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TblHero> findAll() {
		Query queryList = sessionFactory.getCurrentSession().createQuery("FROM TblHero ");
		return queryList.list();
	}

	@Override
	public TblHero findByID(String id) {
		
		Query queryList = sessionFactory.getCurrentSession().createQuery("FROM TblHero WHERE heroId='" + id + "'");
		TblHero tblHero = (TblHero) queryList.list().get(0);
		
		return tblHero;
	}
	
	@Override
	public void insertData(TblHero tblHero) {
		sessionFactory.getCurrentSession().save(tblHero);
	}

	@Override
	public void updateData(TblHero tblHero) {
		sessionFactory.getCurrentSession().update(tblHero);
	}

	@Override
	public void deleteData(TblHero tblHero) {
		sessionFactory.getCurrentSession().delete(tblHero);
	}

	@Override
	public TblHero findByHeroCode(Integer heroCode) {
		
		TblHero tblHero = null;
		Query queryList = sessionFactory.getCurrentSession().createQuery("FROM TblHero WHERE heroCode=" + heroCode);
		if (queryList.list().size() > 0) {
			tblHero = (TblHero) queryList.list().get(0);
		}
		
		return tblHero;
	}

}
