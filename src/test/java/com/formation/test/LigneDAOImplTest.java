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
import com.formation.daos.CommandeDAO;
import com.formation.daos.LigneDAO;
import com.formation.entity.Article;
import com.formation.entity.Commande;
import com.formation.entity.Ligne;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LigneDAOImplTest {

	private static ApplicationContext context;
	private static LigneDAO ligneDAO;
	private static ArticleDAO articleDAO;
	private static CommandeDAO commandeDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		ligneDAO = (LigneDAO) context.getBean("LigneDAO");
		articleDAO = (ArticleDAO) context.getBean("ArticleDAO");
		commandeDAO = (CommandeDAO) context.getBean("CommandeDAO");
	}

	@Test
	public void atestCreateLigne() {
		int expectedResult = 1;
		Article article = new Article();
		articleDAO.CreateArticle(article);
		Ligne ligne = new Ligne(article, 40);
		Commande commande = new Commande();
		commandeDAO.CreateCommande(commande);
		ligne.setCommande(commande);
		ligneDAO.CreateLigne(ligne);
		assertEquals(expectedResult, ligneDAO.getAllLigne().size());
	}

	@Test
	public void btestGetAllLignes() {
		List<Ligne> categorieList = ligneDAO.getAllLigne();
		assertEquals(categorieList.size(), 1);
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
	public void dtestGetLigne() {
		Ligne ligne = ligneDAO.getLigne(1);
		assertEquals(ligne.getQuantite(), 45);
	}
	
	@Test
	public void etestDeleteLigne() {
		ligneDAO.DeleteLigne(ligneDAO.getLigne(1).getId());
		assertEquals(ligneDAO.getLigne(1), null);
	}

}
