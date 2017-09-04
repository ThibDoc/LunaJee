package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.daos.ArticleDAO;
import com.formation.daos.CategorieDAO;
import com.formation.entity.Article;
import com.formation.entity.Categorie;
import com.formation.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Action("/article")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "article.jsp"),
	@Result(name = "insert", location = "article.jsp"),
})
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

	private static final long serialVersionUID = 1L;
	private Article article = new Article();
	
	private Categorie categ;
	
	List<Article> listArticles;

	@Autowired
	private ArticleService articleDAO;
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	List<Categorie> listCateg;

	@Override
	public String execute()throws Exception {
		listCateg = categorieDAO.getAllCategories();
		listArticles = articleDAO.getAllArticles();
		return SUCCESS;
	}
	
	@Action("insertArticle")
	public String insertArticle()throws Exception {
		listCateg = categorieDAO.getAllCategories();
		articleDAO.CreateArticle(getModel());
		listArticles = articleDAO.getAllArticles();
		System.out.println(categ);
		return "insert";
	}


	public List<Article> getListArticles() {
		return listArticles;
	}


	public void setListArticles(List<Article> listArticles) {
		this.listArticles = listArticles;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}

	public List<Categorie> getListCateg() {
		return listCateg;
	}

	public void setListCateg(List<Categorie> listCateg) {
		this.listCateg = listCateg;
	}

	public Categorie getCateg() {
		return categ;
	}

	public void setCateg(Categorie categ) {
		this.categ = categ;
	}

	
	
	
}
