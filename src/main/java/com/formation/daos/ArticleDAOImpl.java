package com.formation.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
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
	public Article getArticle(int code) {
		return this.sessionFactory.getCurrentSession().find(Article.class, code);
	}

	@Override
	public void updateArticle(Article article) {
		this.sessionFactory.getCurrentSession().update(article);
	}

	@Override
	public void DeleteArticle(int code) {
		Article article = (Article) this.sessionFactory.getCurrentSession().load(Article.class, code);
		if(null != article) this.sessionFactory.getCurrentSession().delete(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		return this.sessionFactory.getCurrentSession().createQuery("from Article").list();
	}

	@Override
	public List<Article> getArticleByName(String name) {
		NativeQuery<Article> nativ=  this.sessionFactory.getCurrentSession().createNativeQuery("Select * from article where designation LIKE '%"+name+"%'",Article.class);
		List<Article> article =nativ.getResultList();
		return article;
	}

}
