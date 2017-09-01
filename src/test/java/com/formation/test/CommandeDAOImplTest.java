package com.formation.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.daos.CommandeDAO;
import com.formation.daos.CommandeDAO;
import com.formation.entity.Adresse;
import com.formation.entity.Client;
import com.formation.entity.Commande;
import com.formation.entity.ModeReglements;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommandeDAOImplTest {
	
	private static ApplicationContext context;
	private static CommandeDAO commandeDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		commandeDAO = (CommandeDAO) context.getBean("CommandeDAO");
	}

	@Test
	public void atestCreateCommande() {
		int expectedResult = 1;
		Client client = new Client();
		ModeReglements modeReglements = new ModeReglements();
		Commande commande = new Commande();
		commandeDAO.CreateCommande(commande);
		assertEquals(expectedResult, commandeDAO.getAllCommandes().size());
	}

	@Test
	public void btestGetAllCommandes() {
		List<Commande> categorieList = commandeDAO.getAllCommandes();
		assertEquals(categorieList.size(), 1);
	}
	
	@Test
	public void testGetCommande() {
		Commande commande = commandeDAO.getCommande(1);
		assertEquals(commande.getCode(), 1);
	}

	@Test
	public void ctestUpdateCommande() {
		Commande commande = commandeDAO.getCommande(1);
		commande.setNom("Thib");
		commandeDAO.updateCommande(commande);
		Commande categorieResult = commandeDAO.getCommande(1);
		assertEquals("Thib", categorieResult.getNom());
	}



	@Test
	public void dtestDeleteCommande() {
		commandeDAO.DeleteCommande(commandeDAO.getCommande(1).getCode());
		assertEquals(commandeDAO.getCommande(1), null);
	}
}
