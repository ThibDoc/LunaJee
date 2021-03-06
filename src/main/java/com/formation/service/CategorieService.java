package com.formation.service;

import java.util.List;

import com.formation.entity.Categorie;

public interface CategorieService {
	
	public void CreateCategorie(Categorie categorie);
	
	public Categorie getCategorie(int code);
	
	public void updateCategorie(Categorie categorie);
	
	public void DeleteCategorie(int code);
	
	public List<Categorie> getAllCategories();

}
