package com.formation.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.formation.daos.ArticleDAO;
import com.formation.entity.Article;
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
	
	List<Article> listArticles;

	@Autowired
	private ArticleDAO articleDAO;
	
	
	@Override
	public String execute()throws Exception {
		listArticles = articleDAO.getAllArticles();
		return SUCCESS;
	}
	
	@Action("insertArticle")
	public String insertArticle()throws Exception {
		articleDAO.CreateArticle(getModel());
		listArticles = articleDAO.getAllArticles();
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
	
	
	
}
