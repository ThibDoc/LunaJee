package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.daos.CommandeDAO;
import com.formation.daos.CommandeDAOImpl;
import com.formation.entity.Commande;

@Repository("CommandeService")
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDAO commandeDAO;

	@Override
	public void CreateCommande(Commande commande) {
		// TODO Auto-generated method stub
		commandeDAO.CreateCommande(commande);
	}

	@Override
	public Commande getCommande(int code) {
		// TODO Auto-generated method stub
		return commandeDAO.getCommande(code);
	}

	@Override
	public void updateCommande(Commande commande) {
		// TODO Auto-generated method stub
		commandeDAO.updateCommande(commande);
	}

	@Override
	public void DeleteCommande(int code) {
		// TODO Auto-generated method stub
		commandeDAO.DeleteCommande(code);
	}

	@Override
	public List<Commande> getAllCommandes() {
		// TODO Auto-generated method stub
		return commandeDAO.getAllCommandes();
	}

}
