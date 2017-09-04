package com.formation.service;

import java.util.List;

import com.formation.daos.CommandeDAOImpl;
import com.formation.entity.Commande;

public class CommandeServiceImpl implements CommandeService {
	  
    private CommandeDAOImpl commandeDAOImpl;

    public CommandeDAOImpl getInstance(){
    	commandeDAOImpl = new CommandeDAOImpl();
		return  commandeDAOImpl;
	}

	@Override
	public void CreateCommande(Commande commande) {
		// TODO Auto-generated method stub
		getInstance().CreateCommande(commande);
	}

	@Override
	public Commande getCommande(int code) {
		// TODO Auto-generated method stub
		return getInstance().getCommande(code);
	}

	@Override
	public void updateCommande(Commande commande) {
		// TODO Auto-generated method stub
		getInstance().updateCommande(commande);
	}

	@Override
	public void DeleteCommande(int code) {
		// TODO Auto-generated method stub
		getInstance().DeleteCommande(code);
	}

	@Override
	public List<Commande> getAllCommandes() {
		// TODO Auto-generated method stub
		return getInstance().getAllCommandes();
	}

	
}
