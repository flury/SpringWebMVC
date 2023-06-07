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

}
