package com.formation.action;

import java.nio.file.Path;
import java.nio.file.Paths;
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
import com.formation.util.Statistique;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

@Action("/article")
@ResultPath("/WEB-INF/pages")
@Results({
	@Result(name = "success", location = "article.jsp"),
	@Result(name = "insert", location = "article.jsp"),
	@Result(name = "delete", location = "article.jsp"),
	@Result(name = "input", location = "createArticle.jsp"),
	@Result(name = "update", location = "article.jsp"),
	@Result(name = "updatePage", location = "updateArticle.jsp"),
	@Result(name = "createPage", location = "createArticle.jsp"),
	@Result(name = "search", location = "article.jsp"),
})
public class ArticleAction extends ActionSupport implements ModelDriven<Article>,Preparable {

	private static final long serialVersionUID = 1L;
	
	private Article article = new Article(); // Article qui va étre crée
	private Article articleUpdate; // Article qui va être modifier
	
	private int categ; // Pour récupérer la catégorie
	private int codeArt; // Pour récupérer l'article
	private String name; // Pour rechercher un article 

	@Autowired
	private ArticleService articleDAO;
	
	@Autowired
	private CategorieDAO categorieDAO;
	
	List<Categorie> listCateg; // La liste des catégorie
	List<Article> listArticles; // La liste des articles
	
	@Override
	public String execute()throws Exception {
		load();
		return SUCCESS;
	}
	
	@Action("insertArticle") // action pour crée un article
	public String insertArticle()throws Exception {
		load();
		article.setReference(categorieDAO.getCategorie(categ));
		articleDAO.CreateArticle(getModel());
		load();
		return "insert";
	}

	@Action("deleteArticle") // action pour supprimer un article
	public String deleteArticle()throws Exception {
		articleDAO.DeleteArticle(codeArt);
		load();
		return "delete";
	}
	
	@Action("updateArticlePage") // action pour afficher la page d'update
	public String updateArticlePage()throws Exception {
		load();
		articleUpdate = articleDAO.getArticle(codeArt);
		articleUpdate.setCode(codeArt);
		
		return "updatePage";
	}
	
	@Action("updateArticle") // action qui met a jour un article
	public String updateArticle()throws Exception {
		articleUpdate.setReference(categorieDAO.getCategorie(categ));
		articleUpdate.setCode(codeArt);
		articleDAO.updateArticle(articleUpdate);
		load();
		return "update";
	}
	
	@Action("createArticlePage") //action qui affiche la page de création d'article
	public String createPage()throws Exception {
		load();
		return "createPage";
	}
	
	@Action("searchArticle") // action qui recherche un article par nom
	public String searchArticle()throws Exception {
		load();
		listArticles.clear();
		listArticles = articleDAO.getArticleByName(name);
		return "search";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void prepare() throws Exception {
		load();
	}
	
}
