package com.formation.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.entity.Article;

@Repository("ArticleDAO")
@Transactional 
public class ArticleDAOImpl implements ArticleDAO{

	@Autowired 
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void CreateArticle(Article article) {
		this.sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public Article getArticle(Integer code) {
		return sessionFactory.getCurrentSession().load(Article.class, code);
	}

	@Override
	public void updateArticle(Article article) {
		this.sessionFactory.getCurrentSession().update(article);
	}

	@Override
	public void DeleteArticle(Integer code) {
		Article article = (Article) sessionFactory.getCurrentSession().load(Article.class, code);
		if(null != article) this.sessionFactory.getCurrentSession().delete(article);
	}

	@Override
	public List<Article> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Article").list();
	}

}
