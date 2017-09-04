package com.formation.service;

import java.util.List;

import com.formation.daos.ArticleDAOImpl;
import com.formation.entity.Article;

public class ArticleServiceImpl implements ArticleService {
	  
    private ArticleDAOImpl articleDAOImpl;

    public ArticleDAOImpl getInstance(){
    	articleDAOImpl = new ArticleDAOImpl();
		return  articleDAOImpl;
	}

	@Override
	public void CreateArticle(Article article) {
		// TODO Auto-generated method stub
		getInstance().CreateArticle(article);
	}

	@Override
	public Article getArticle(int code) {
		// TODO Auto-generated method stub
		return getInstance().getArticle(code);
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		getInstance().updateArticle(article);
	}

	@Override
	public void DeleteArticle(int code) {
		// TODO Auto-generated method stub
		getInstance().DeleteArticle(code);
	}

	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return getInstance().getAllArticles();
	}

	
}
