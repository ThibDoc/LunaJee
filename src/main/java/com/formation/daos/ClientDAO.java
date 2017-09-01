package com.formation.daos;

import java.util.List;

import com.formation.entity.Client;

public interface ClientDAO {
	
	public void CreateClient(Client client);
	
	public Client getClient(int i);
	
	public void updateClient(Client client);
	
	public void DeleteClient(int code);
	
	public List<Client> getAllClients();

}
