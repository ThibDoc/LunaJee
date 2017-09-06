package com.formation.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.daos.ClientDAO;
import com.formation.daos.CommandeDAO;

import com.formation.entity.Client;
import com.formation.entity.Commande;
import com.formation.entity.Ligne;
import com.formation.entity.ModeReglements;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommandeDAOImplTest {
	
	private static ApplicationContext context;
	private static CommandeDAO commandeDAO;
	private static ClientDAO clientDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		commandeDAO = (CommandeDAO) context.getBean("CommandeDAO");
		clientDAO = (ClientDAO) context.getBean("ClientDAO");
	}

	@Test
	public void atestCreateCommande() {
		int expectedResult = 1;
		Client client = new Client();
		clientDAO.CreateClient(client);
		ModeReglements modeReglements = new ModeReglements();
		modeReglements.setCode(1);
		modeReglements.setType("CB");
		List<Ligne> lignes = new ArrayList<>();
		Commande commande = new Commande(client, modeReglements, new Date(), lignes);
		
		commandeDAO.CreateCommande(commande);;
		assertEquals(expectedResult, commandeDAO.getAllCommandes().size());
	}

	@Test
	public void btestGetAllCommandes() {
		List<Commande> categorieList = commandeDAO.getAllCommandes();
		assertEquals(categorieList.size(), 1);
	}
	
	@Test
	public void ctestGetCommande() {
		Commande commande = commandeDAO.getCommande(1);
		assertEquals(commande.getCode(), 1);
	}

	@Test
	public void dtestUpdateCommande() {
		Commande commande = commandeDAO.getCommande(1);
		Date date = new Date();
		commande.setDate(date);
		commandeDAO.updateCommande(commande);
		Commande categorieResult = commandeDAO.getCommande(1);
		assertEquals(date, categorieResult.getDate());
	}



	@Test
	public void etestDeleteCommande() {
		commandeDAO.DeleteCommande(commandeDAO.getCommande(1).getCode());
		assertEquals(commandeDAO.getCommande(1), null);
	}
}
