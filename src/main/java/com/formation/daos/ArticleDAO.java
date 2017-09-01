package com.formation.daos;

import java.util.List;

import com.formation.entity.Article;

public interface ArticleDAO {
	
	public void CreateArticle(Article article);
	
	public Article getArticle(Integer code);
	
	public void updateArticle(Article article);
	
	public void DeleteArticle(Integer code);
	
	public List<Article> getAllEmployees();

}
