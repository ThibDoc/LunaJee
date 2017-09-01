package com.formation.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * La classe catégorie est à compléter lorsque vous aurez réalisé
 * l'ensemble du projet Luna tel que proposé dans le livre.
 * Nous vous laissons donc le soin de créer vous mêmes
 * les méthodes CRUD en vous aidant de tout ce qui a été vu
 * et mis en oeuvre pour bâtir le projet Luna.
 * Pensez alors à créer aussi un modèle et une IHM
 * selon la même démarche suivie pour les classes entité
 * Client, Article, Commandes et Ligne  
 */
@Entity
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Basic
	private String designation;

	public Categorie() {
		super();
	}

	public int getCode() {
		return code;
	}

	public Categorie setCode(int code) {
		this.code = code;
		return this;
	}

	public String getDesignation() {
		return designation;
	}

	public Categorie setDesignation(String designation) {
		this.designation = designation;
		return this;
	}
}
