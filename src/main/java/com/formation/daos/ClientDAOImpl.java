package com.formation.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.entity.Client;

@Repository("ClientDAO")
@Transactional 
public class ClientDAOImpl implements ClientDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void CreateClient(Client client) {
		this.sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public Client getClient(String code) {
		return sessionFactory.getCurrentSession().load(Client.class, code);
	}

	@Override
	public void updateClient(Client client) {
		this.sessionFactory.getCurrentSession().update(client);
	}

	@Override
	public void DeleteClient(String code) {
		Client client = (Client) sessionFactory.getCurrentSession().load(Client.class, code);
		if(null != client) this.sessionFactory.getCurrentSession().delete(client);
	}

	@Override
	public List<Client> getAllClients() {
		return this.sessionFactory.getCurrentSession().createQuery("from Client").list();
	}

}
