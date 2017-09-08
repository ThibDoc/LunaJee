package com.formation.daos;

import java.util.List;

import com.formation.entity.Article;

public interface ArticleDAO {
	
	public void CreateArticle(Article article);
	
	public Article getArticle(int code);
	
	public List<Article> getArticleByName(String name);
	
	public void updateArticle(Article article);
	
	public void DeleteArticle(int code);
	
	public List<String> getArticleUtil();
	
	public List<Article> getAllArticles();

}
