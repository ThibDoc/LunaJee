package com.formation.daos;

import java.util.List;

import com.formation.entity.Commande;

public interface CommandeDAO {
	
	public void CreateCommande(Commande commande);
	
	public Commande getCommande(int code);
	
	public void updateCommande(Commande commande);
	
	public void DeleteCommande(int code);
	
	public List<Commande> getAllEmployees();

}
