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

import com.formation.daos.ClientDAO;
import com.formation.entity.Adresse;
import com.formation.entity.Client;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceImplTest {

	private static ApplicationContext context;
	private static ClientDAO clientDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		clientDAO = (ClientDAO) context.getBean("ClientDAO");
	}

	@Test
	public void atestCreateClient() {
		int expectedResult = 1;
		Adresse adresse = new Adresse("Rue de la Puqée du Calui", "08888", "Pouilly");
		Client client = new Client("Docquier", "Thibault", true,  new Date(2011, 05, 11, 11, 55), adresse);
		clientDAO.CreateClient(client);
		assertEquals(expectedResult, clientDAO.getAllClients().size());
	}

	@Test
	public void btestGetAllClients() {
		List<Client> categorieList = clientDAO.getAllClients();
		assertEquals(categorieList.size(), 1);
	}
	
	@Test
	public void dtestGetClient() {
		Client client = clientDAO.getClient(1);
		assertEquals(client.getCode(), 1);
	}

	@Test
	public void ctestUpdateClient() {
		Client client = clientDAO.getClient(1);
		client.setNom("Thib");
		clientDAO.updateClient(client);
		Client categorieResult = clientDAO.getClient(1);
		assertEquals("Thib", categorieResult.getNom());
	}



	@Test
	public void etestDeleteClient() {
		clientDAO.DeleteClient(clientDAO.getClient(1).getCode());
		assertEquals(clientDAO.getClient(1), null);
	}

}
