package com.formation.test;

import static org.junit.Assert.assertEquals;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.util.StrutsTestCaseHelper;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.formation.daos.ArticleDAO;
import com.formation.daos.CategorieDAO;
import com.opensymphony.xwork2.ActionProxy;

public class ArticleActionTest {
	
	private static ApplicationContext context;
	private static ArticleDAO articleDAO;
	
	@BeforeClass
	public static void oneTimeSetUp() {
		context = new ClassPathXmlApplicationContext("application-Context.xml");
		articleDAO = (ArticleDAO) context.getBean("ArticleDAO");
	}
	
	public void insertArticleTest() {
		
		assertEquals(1, 1);

	}

	public void deleteArticle() {
		assertEquals(1, 1);
	}
	
	public void updateArticlePage() {
		
		assertEquals(1, 1);
	}
	
	public void updateArticle() {
		assertEquals(1, 1);
	}
	
	public void createPage() {
		
		assertEquals(1, 1);
	}
	
	public void searchArticle() {
		
		assertEquals(1, 1);
	}
   
}
