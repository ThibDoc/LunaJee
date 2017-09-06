package com.formation.service;

import java.util.List;

import com.formation.entity.Article;

public interface ArticleService {
	
	public void CreateArticle(Article article);
	
	public Article getArticle(int code);
	
	public List<Article> getArticleByName(String name);
	
	public void updateArticle(Article article);
	
	public void DeleteArticle(int code);
	
	public List<Article> getAllArticles();

}