package com.formation.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	private Categorie categorie;

//	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//	private Set<Fournisseur> fournisseurs = new HashSet<>();
	
	@Basic
	private String designation;

	@Basic
	private int quantite;

	@Column(name="prix_unitaire")
	private double prixUnitaire;

	/*
	 * Constructeur
	 */
	public Article( int codeCategorie,
			String designation,
			int quantite, double prixUnitaire) {
		this(
				new Categorie().setCode(codeCategorie),
				designation, 
				quantite, prixUnitaire);
	}
	
	public Article(Categorie categorie,
			String designation,
			int quantite, double prixUnitaire) {
		this.categorie = categorie;
		this.designation = designation;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;	
	}

	/*
	 * Constructeur 2
	 */
	public Article() {
	}

	/*
	 * Accesseurs
	 */
	public int getCode() {
		return code;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public String getDesignation() {
		return designation;
	}

	public int getQuantite() {
		return quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}


	
//	public Set<Fournisseur> getFournisseurs() {
//		return this.fournisseurs;
//	}

	/*
	 * Mutateurs
	 */
	public void setCode(int code) {
		this.code = code;
	}

	public void setReference(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setPrixUnitaire(double prix_unitaire) {
		this.prixUnitaire = prix_unitaire;
	}

//	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
//		this.fournisseurs = fournisseurs;
//	}
	

}
