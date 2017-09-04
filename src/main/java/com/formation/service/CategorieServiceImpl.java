package com.formation.service;

import java.util.List;

import com.formation.daos.CategorieDAOImpl;
import com.formation.entity.Categorie;

public class CategorieServiceImpl implements CategorieService {
	  
    private CategorieDAOImpl categorieDAOImpl;

    public CategorieDAOImpl getInstance(){
    	categorieDAOImpl = new CategorieDAOImpl();
		return  categorieDAOImpl;
	}

	@Override
	public void CreateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		getInstance().CreateCategorie(categorie);
	}

	@Override
	public Categorie getCategorie(int code) {
		// TODO Auto-generated method stub
		return getInstance().getCategorie(code);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		getInstance().updateCategorie(categorie);
	}

	@Override
	public void DeleteCategorie(int code) {
		// TODO Auto-generated method stub
		getInstance().DeleteCategorie(code);
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return getInstance().getAllCategories();
	}

	
}
