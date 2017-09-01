package com.formation.daos;

import java.util.List;

import com.formation.entity.Client;

public interface ClientDAO {
	
	public void CreateClient(Client client);
	
	public Client getClient(String code);
	
	public void updateClient(Client client);
	
	public void DeleteClient(String code);
	
	public List<Client> getAllClients();

}
