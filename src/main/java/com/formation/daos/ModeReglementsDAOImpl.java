package com.formation.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.entity.ModeReglements;

@Repository("ModeReglementsDAO")
@Transactional 
public class ModeReglementsDAOImpl implements ModeReglementsDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void CreateModeReglements(ModeReglements modeReglements) {
		this.sessionFactory.getCurrentSession().save(modeReglements);
	}

	@Override
	public ModeReglements getModeReglements(int code) {
		return this.sessionFactory.getCurrentSession().find(ModeReglements.class, code);
	}

	@Override
	public void updateModeReglements(ModeReglements modeReglements) {
		this.sessionFactory.getCurrentSession().update(modeReglements);
	}

	@Override
	public void DeleteModeReglements(int code) {
		ModeReglements modeReglements = (ModeReglements) this.sessionFactory.getCurrentSession().load(ModeReglements.class, code);
		if(null != modeReglements) this.sessionFactory.getCurrentSession().delete(modeReglements);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModeReglements> getAllModeReglements() {
		return this.sessionFactory.getCurrentSession().createQuery("from ModeReglements").list();
	}


}
