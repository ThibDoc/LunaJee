package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.daos.ArticleDAO;
import com.formation.entity.Article;

@Repository("ArticleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public void CreateArticle(Article article) {
		// TODO Auto-generated method stub
		articleDAO.CreateArticle(article);
	}

	@Override
	public Article getArticle(int code) {
		// TODO Auto-generated method stub
		return articleDAO.getArticle(code);
	}

	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		articleDAO.updateArticle(article);
	}

	@Override
	public void DeleteArticle(int code) {
		// TODO Auto-generated method stub
		articleDAO.DeleteArticle(code);
	}

	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articleDAO.getAllArticles();
	}

	@Override
	public Article getArticleByName(String name) {
		// TODO Auto-generated method stub
		return articleDAO.getArticleByName(name);
	}

}
