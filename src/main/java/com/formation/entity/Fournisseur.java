package com.formation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Fournisseur implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    private long code;
	
	private String societe;
	
	@OneToOne
	private Adresse adresse;
	
	public long getCode() {
		return this.code;
	}
	
	public String getSociete() {
		return this.societe;
	}
	
	public Adresse getAdresse() {
		return this.adresse;
	}
	
	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}	
}
