package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.daos.CategorieDAO;
import com.formation.daos.CategorieDAOImpl;
import com.formation.entity.Categorie;

@Repository("CategorieService")
public class CategorieServiceImpl implements CategorieService {
	@Autowired
	private CategorieDAO categorieDAO;

	@Override
	public void CreateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieDAO.CreateCategorie(categorie);
	}

	@Override
	public Categorie getCategorie(int code) {
		// TODO Auto-generated method stub
		return categorieDAO.getCategorie(code);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieDAO.updateCategorie(categorie);
	}

	@Override
	public void DeleteCategorie(int code) {
		// TODO Auto-generated method stub
		categorieDAO.DeleteCategorie(code);
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return categorieDAO.getAllCategories();
	}

}
