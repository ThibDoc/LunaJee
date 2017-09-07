package com.formation.daos;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> getAllCommandes() {
		return this.sessionFactory.getCurrentSession().createQuery("from Commande").list();
	}

	@Override
	public List<Commande> getCommandeByCli(int id) {
		NativeQuery<Commande> nativ=  this.sessionFactory.getCurrentSession().createNativeQuery("Select * from commande where client_code="+id,Commande.class);
		List<Commande> commandes =nativ.getResultList();
		return commandes;
	}

}
