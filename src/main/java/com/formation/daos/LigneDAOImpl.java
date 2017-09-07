package com.formation.daos;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.formation.entity.Ligne;

@Repository("LigneDAO")
@Transactional 
public class LigneDAOImpl implements LigneDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void CreateLigne(Ligne ligne) {
		this.sessionFactory.getCurrentSession().save(ligne);
	}

	@Override
	public Ligne getLigne(int code) {
		return this.sessionFactory.getCurrentSession().find(Ligne.class, code);
	}

	@Override
	public void updateLigne(Ligne ligne) {
		this.sessionFactory.getCurrentSession().update(ligne);
	}

	@Override
	public void DeleteLigne(int code) {
		Ligne ligne = (Ligne) this.sessionFactory.getCurrentSession().load(Ligne.class, code);
		if(null != ligne) this.sessionFactory.getCurrentSession().delete(ligne);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ligne> getAllLigne() {
		return this.sessionFactory.getCurrentSession().createQuery("from Ligne").list();
	}

	@Override
	public void deleteAllLigneComm(int code) {
		NativeQuery<Ligne> nativ=  this.sessionFactory.getCurrentSession().createNativeQuery("Select * from ligne where commande_code="+code,Ligne.class);
		List<Ligne> lignes =nativ.getResultList();
		for(Ligne l : lignes) {
			this.sessionFactory.getCurrentSession().delete(l);
		}
	}


}
