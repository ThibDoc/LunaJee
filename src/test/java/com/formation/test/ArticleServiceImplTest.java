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
import com.formation.entity.Article;
import com.formation.entity.Categorie;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleServiceImplTest {
	private static ApplicationContext context;
	private static ArticleDAO articleDAO;
	private static CategorieDAO categorieDAO;

	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		articleDAO = (ArticleDAO) context.getBean("ArticleDAO");
		categorieDAO = (CategorieDAO) context.getBean("CategorieDAO");
	}

	@Test
	public void atestCreateArticle() {
		Categorie categorie = new Categorie("Electroménager");
		categorieDAO.CreateCategorie(categorie);
		Article article = new Article(categorie, "Lave Linge", 50, 399);
		articleDAO.CreateArticle(article);
		assertEquals(1, articleDAO.getAllArticles().size());
	}

	@Test
	public void btestGetAllArticles() {
		List<Article> categorieList = articleDAO.getAllArticles();
		assertEquals(categorieList.size(), 1);
	}
	
	@Test
	public void ctestGetArticle() {
		Article article = articleDAO.getArticle(1);
		assertEquals(article.getCode(), 1);
	}

	@Test
	public void dtestUpdateArticle() {
		Article article = articleDAO.getArticle(1);
		article.setDesignation("Lave Vaisselle");
		articleDAO.updateArticle(article);
		Article categorieResult = articleDAO.getArticle(1);
		assertEquals("Lave Vaisselle", categorieResult.getDesignation());
	}



	@Test
	public void etestDeleteArticle() {
		articleDAO.DeleteArticle(articleDAO.getArticle(1).getCode());
		assertEquals(articleDAO.getArticle(1), null);
	}
}
