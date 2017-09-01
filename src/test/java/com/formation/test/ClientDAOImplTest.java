package com.formation.test;

import java.time.Instant;
import java.time.LocalDate;
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
import com.formation.util.GestionDates;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.JVM)
public class ClientDAOImplTest {

	private static ApplicationContext context;
	private static ClientDAO clientDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		clientDAO = (ClientDAO) context.getBean("ClientDAO");
	}

	@Test
	public void testCreateClient() {
		int expectedResult = 1;
		Adresse adresse = new Adresse("Rue de la Puqée du Calui", "08888", "Pouilly");
		Client client = new Client("Docquier", "Thibault", true,  GestionDates.date(Instant.now()), adresse);
		clientDAO.CreateClient(client);
		Assert.assertEquals(expectedResult, clientDAO.getAllClients().size());
	}

	@Test
	public void testGetAllClients() {
		List<Client> categorieList = clientDAO.getAllClients();
		Assert.assertEquals(1, categorieList.size());
		Client categorieExpected = categorieList.get(0);
		Client categorieResult = clientDAO.getClient(categorieExpected.getCode());
		Assert.assertEquals(categorieExpected.getCode(), categorieResult.getCode());
	}

	@Test
	public void testUpdateClient() {
		List<Client> categorieList = clientDAO.getAllClients();
		Assert.assertEquals(1, categorieList.size());
		Client categorieExpected = categorieList.get(0);
		categorieExpected.setNom("Thib");
		clientDAO.updateClient(categorieExpected);
		Client categorieResult = clientDAO.getClient("1");
		Assert.assertEquals("Thib", categorieResult.getNom());
	}



	@Test
	public void testDeleteData() {
		List<Client> categorieList = clientDAO.getAllClients();
		Assert.assertEquals(1, categorieList.size());
		Client categorieExpected = categorieList.get(0);
		String codeExpected = categorieExpected.getCode();
		clientDAO.DeleteClient(codeExpected);
		Client categorieResult = clientDAO.getClient(codeExpected);
		Assert.assertEquals(categorieResult, null);
	}

}
