package com.formation.daos;

import java.util.List;

import com.formation.entity.Commande;

public interface CommandeDAO {
	
	public void CreateCommande(Commande commande);
	
	public Commande getCommande(Integer code);
	
	public void updateCommande(Commande commande);
	
	public void DeleteCommande(Integer code);
	
	public List<Commande> getAllEmployees();

}
