package com.formation.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.entity.Commande;

@Repository("CommandeDAO")
@Transactional 
public class CommandeDAOImpl implements CommandeDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void CreateCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().save(commande);
	}

	@Override
	public Commande getCommande(Integer code) {
		return sessionFactory.getCurrentSession().load(Commande.class, code);
	}

	@Override
	public void updateCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().update(commande);
	}

	@Override
	public void DeleteCommande(Integer code) {
		Commande commande = (Commande) sessionFactory.getCurrentSession().load(Commande.class, code);
		if(null != commande) this.sessionFactory.getCurrentSession().delete(commande);
	}

	@Override
	public List<Commande> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Commande").list();
	}

}
