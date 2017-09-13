package com.formation.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.daos.ArticleDAO;
import com.formation.entity.Adresse;

public class AdresseTest {
	
	
	
	@BeforeClass
	public static void oneTimeSetUp() {
		
	}

	@Test
	public void testGetRue() {
		Adresse adresse= new Adresse("rue de merde", "62210", "Avion");
		assertEquals("rue de merde", adresse.getRue());
	}

	@Test
	public void testSetRue() {
		Adresse adresse= new Adresse("rue de merde", "62210", "Avion");
		adresse.setRue("rue de merde2");
		assertEquals("rue de merde2", adresse.getRue());
	}

	@Test
	public void testGetCodePostal() {
		Adresse adresse= new Adresse("rue de merde", "62210", "Avion");
		assertEquals("62210", adresse.getCodePostal());
	}

	@Test
	public void testSetCodePostal() {
		Adresse adresse= new Adresse("rue de merde", "62210", "Avion");
		adresse.setCodePostal("62211");
		assertEquals("62211", adresse.getCodePostal());
	}

	@Test
	public void testGetVille() {
		Adresse adresse= new Adresse("rue de merde", "62210", "Avion");
		assertEquals("Avion", adresse.getVille());
	}

	@Test
	public void testSetVille() {
		Adresse adresse= new Adresse("rue de merde", "62210", "Avion");
		adresse.setVille("Avione");
		assertEquals("Avione", adresse.getVille());
	}

}
