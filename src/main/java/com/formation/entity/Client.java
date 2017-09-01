package com.formation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	// Propriétés de base de la classe
	// -------------------------------
	// l'identifiant en base de données
	@Id
	@GeneratedValue
	private int code;


	private String nom;

	private String prenom;

	private boolean carte_fidele;

	@Temporal(TemporalType.DATE)
	private Date date;

	@OneToOne(cascade=CascadeType.ALL)
	private Adresse adresse;

	// Getters de base
	// ---------------
	public int getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public boolean isCarteFidele() {
		return carte_fidele;
	}

	// Setters
	public void setCode(int code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setCarteFidele(boolean carte_fidele) {
		this.carte_fidele = carte_fidele;
	}

	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Adresse getAdresse() {
		return this.adresse;
	}

	public Client(String nom, String prenom, boolean carte_fidele, Date date, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.carte_fidele = carte_fidele;
//		Instant creation;
//		setDateCreation(creation);
//		LocalDate.of(date.getYear() +1900, date.getMonth(), date.getDate());
		this.date = date;
		this.adresse = adresse;
	}

	/**
	 * Utilisé par JPA.
	 */
	public Client() {
		
	}

	@Override
	public String toString() {
		return "Client [code=" + this.code + ", nom=" + this.nom + ", prenom="
				+ this.prenom + ", carte_fidele=" + this.carte_fidele
				+ ", date=" + this.date + "]";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	
}
