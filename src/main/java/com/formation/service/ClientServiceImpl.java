package com.formation.service;

import java.util.List;

import com.formation.daos.ClientDAOImpl;
import com.formation.entity.Client;

public class ClientServiceImpl implements ClientService {
	  
    private ClientDAOImpl clientDAOImpl;

    public ClientDAOImpl getInstance(){
    	clientDAOImpl = new ClientDAOImpl();
		return  clientDAOImpl;
	}

	@Override
	public void CreateClient(Client client) {
		// TODO Auto-generated method stub
		getInstance().CreateClient(client);
	}

	@Override
	public Client getClient(int code) {
		// TODO Auto-generated method stub
		return getInstance().getClient(code);
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		getInstance().updateClient(client);
	}

	@Override
	public void DeleteClient(int code) {
		// TODO Auto-generated method stub
		getInstance().DeleteClient(code);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return getInstance().getAllClients();
	}

	
}
