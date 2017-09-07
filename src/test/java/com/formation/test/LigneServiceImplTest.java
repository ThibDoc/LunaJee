package com.formation.test;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.formation.daos.LigneDAO;
import com.formation.entity.Ligne;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LigneServiceImplTest {

	private static ApplicationContext context;
	private static LigneDAO ligneDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		ligneDAO = (LigneDAO) context.getBean("LigneDAO");
	}

	@Test
	public void atestCreateLigne() {
		int expectedResult = 1;
		Ligne ligne = new Ligne(null, 40);
		ligneDAO.CreateLigne(ligne);
		assertEquals(expectedResult, ligneDAO.getAllLigne().size());
	}

	@Test
	public void btestGetAllLignes() {
		List<Ligne> categorieList = ligneDAO.getAllLigne();
		assertEquals(categorieList.size(), 1);
	}
	
	@Test
	public void dtestGetLigne() {
		Ligne ligne = ligneDAO.getLigne(1);
		assertEquals(ligne.getQuantite(), 40);
	}

	@Test
	public void ctestUpdateLigne() {
		Ligne ligne = ligneDAO.getLigne(1);
		ligne.setQuantite(45);
		ligneDAO.updateLigne(ligne);
		Ligne categorieResult = ligneDAO.getLigne(1);
		assertEquals(45, categorieResult.getQuantite());
	}
	
	@Test
	public void etestDeleteLigne() {
		ligneDAO.DeleteLigne(ligneDAO.getLigne(1).getId());
		assertEquals(ligneDAO.getLigne(1), null);
	}

}
