package com.formation.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	public Categorie(String designation) {
		super();
		this.designation = designation;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;

	@Basic
	private String designation;

	public Categorie() {
		
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
