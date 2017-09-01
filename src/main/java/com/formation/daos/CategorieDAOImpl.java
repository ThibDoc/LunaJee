package com.formation.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.entity.Categorie;

@Repository("CategorieDAO")
@Transactional 
public class CategorieDAOImpl implements CategorieDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void CreateCategorie(Categorie categorie) {
		this.sessionFactory.getCurrentSession().save(categorie);
	}

	@Override
	public Categorie getCategorie(int code) {
		return this.sessionFactory.getCurrentSession().find(Categorie.class, code);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		this.sessionFactory.getCurrentSession().update(categorie);
	}

	@Override
	public void DeleteCategorie(int code) {
		Categorie categorie = (Categorie) this.sessionFactory.getCurrentSession().load(Categorie.class, code);
		if(null != categorie) this.sessionFactory.getCurrentSession().delete(categorie);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategories() {
		return this.sessionFactory.getCurrentSession().createQuery("from Categorie").list();
	}

}
