package com.formation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ligne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(optional=false)
	private Article article;

	@ManyToOne(optional=false)
	private Commande commande;

	private int quantite;

	/*
	 * Constructeur 1
	 */
	public Ligne(Article unArticle, int quantite) {
		this();
		this.article = unArticle;
		this.quantite = quantite;
	}

	public Ligne() {
		super();
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article unArticle) {
		this.article = unArticle;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return article.getPrixUnitaire();
	}

	public double getTotal() {
		return quantite * getPrixUnitaire();
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
}
