package com.formation.test;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.daos.ArticleDAO;
import com.formation.daos.CategorieDAO;
import com.formation.daos.ModeReglementsDAO;
import com.formation.entity.Article;
import com.formation.entity.Categorie;
import com.formation.entity.ModeReglements;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModeReglementsServiceImplTest {

	private static ApplicationContext context;
	private static ModeReglementsDAO modeReglementsDAO;
	private static CategorieDAO categorieDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		modeReglementsDAO = (ModeReglementsDAO) context.getBean("ModeReglementsDAO");
		categorieDAO = (CategorieDAO) context.getBean("CategorieDAO");
	}

	@Test
	public void atestCreateModeReglements() {
		
		ModeReglements modeReglements = new ModeReglements("CB");
		modeReglementsDAO.CreateModeReglements(modeReglements);
		assertEquals(1, modeReglementsDAO.getAllModeReglements().size());
	}

	@Test
	public void btestGetAllModeReglementss() {
		List<ModeReglements> categorieList = modeReglementsDAO.getAllModeReglements();
		assertEquals(categorieList.size(), 1);
	}
	
	@Test
	public void ctestGetModeReglements() {
		ModeReglements modeReglements = modeReglementsDAO.getModeReglements(1);
		assertEquals(modeReglements.getType(), "CB");
	}

	@Test
	public void dtestUpdateModeReglements() {
		ModeReglements modeReglements = modeReglementsDAO.getModeReglements(1);
		modeReglements.setType("Paypal");
		modeReglementsDAO.updateModeReglements(modeReglements);
		ModeReglements categorieResult = modeReglementsDAO.getModeReglements(1);
		assertEquals("Paypal", categorieResult.getType());
	}

	@Test
	public void etestDeleteModeReglements() {
		modeReglementsDAO.DeleteModeReglements(modeReglementsDAO.getModeReglements(1).getCode());
		assertEquals(modeReglementsDAO.getModeReglements(1), null);
	}

}
