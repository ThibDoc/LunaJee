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
	public Commande getCommande(int code) {
		return this.sessionFactory.getCurrentSession().find(Commande.class, code);
	}

	@Override
	public void updateCommande(Commande commande) {
		this.sessionFactory.getCurrentSession().update(commande);
	}

	@Override
	public void DeleteCommande(int code) {
		Commande commande = (Commande) this.sessionFactory.getCurrentSession().load(Commande.class, code);
		if(null != commande) this.sessionFactory.getCurrentSession().delete(commande);
	}

	@Override
	public List<Commande> getAllCommandes() {
		return this.sessionFactory.getCurrentSession().createQuery("from Commande").list();
	}

}
