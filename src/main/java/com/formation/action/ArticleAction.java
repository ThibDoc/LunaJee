package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Result(name = "delete", location = "article.jsp"),
	@Result(name = "update", location = "article.jsp"),
	@Result(name = "updatePage", location = "updateArticle.jsp"),
})
public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

	private static final long serialVersionUID = 1L;
	
	private Article article = new Article();
	private int categ;
	private int codeArt;
	private Article articleUpdate;

	@Autowired
	private ArticleService articleDAO;
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	List<Categorie> listCateg;
	List<Article> listArticles;
	
	@Override
	public String execute()throws Exception {
		load();
		return SUCCESS;
	}
	
	@Action("insertArticle")
	public String insertArticle()throws Exception {
		load();
		article.setReference(categorieDAO.getCategorie(categ));
		articleDAO.CreateArticle(getModel());
		load();
		return "insert";
	}

	@Action("deleteArticle")
	public String deleteArticle()throws Exception {
		articleDAO.DeleteArticle(codeArt);
		load();
		return "delete";
	}
	
	@Action("updateArticlePage")
	public String updateArticlePage()throws Exception {
		load();
		articleUpdate = articleDAO.getArticle(codeArt);
		articleUpdate.setCode(codeArt);
		return "updatePage";
	}
	
	@Action("updateArticle")
	public String updateArticle()throws Exception {
		load();
		articleUpdate.setReference(categorieDAO.getCategorie(categ));
		articleDAO.updateArticle(articleUpdate);
		load();
		return "update";
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
		return article;
	}

	public List<Categorie> getListCateg() {
		return listCateg;
	}

	public void setListCateg(List<Categorie> listCateg) {
		this.listCateg = listCateg;
	}

	public int getCateg() {
		return categ;
	}

	public void setCateg(int categ) {
		this.categ = categ;
	}

	public Article getArticleUpdate() {
		return articleUpdate;
	}

	public void setArticleUpdate(Article articleUpdate) {
		this.articleUpdate = articleUpdate;
	}

	public int getCodeArt() {
		return codeArt;
	}

	public void setCodeArt(int codeArt) {
		this.codeArt = codeArt;
	}
	
	public void load() {
		listArticles = articleDAO.getAllArticles();
		listCateg = categorieDAO.getAllCategories();
	}

}
