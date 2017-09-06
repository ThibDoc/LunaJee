package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.formation.daos.ClientDAO;

import com.formation.entity.Client;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDAO clientDAO;

	@Override
	public void CreateClient(Client client) {
		// TODO Auto-generated method stub
		clientDAO.CreateClient(client);
	}

	@Override
	public Client getClient(int code) {
		// TODO Auto-generated method stub
		return clientDAO.getClient(code);
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		clientDAO.updateClient(client);
	}

	@Override
	public void DeleteClient(int code) {
		// TODO Auto-generated method stub
		clientDAO.DeleteClient(code);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientDAO.getAllClients();
	}

	@Override
	public List<Client> getClientByName(String name) {
		// TODO Auto-generated method stub
		return clientDAO.getClientByName(name);
	}

}
