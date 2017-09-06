package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.daos.LigneDAO;
import com.formation.daos.LigneDAOImpl;
import com.formation.entity.Ligne;

@Repository("LigneService")
public class LigneServiceImpl implements LigneService {
	@Autowired
	private LigneDAO ligneDAO;

	@Override
	public void CreateLigne(Ligne ligne) {
		// TODO Auto-generated method stub
		ligneDAO.CreateLigne(ligne);
	}

	@Override
	public Ligne getLigne(int code) {
		// TODO Auto-generated method stub
		return ligneDAO.getLigne(code);
	}

	@Override
	public void updateLigne(Ligne ligne) {
		// TODO Auto-generated method stub
		ligneDAO.updateLigne(ligne);
	}

	@Override
	public void DeleteLigne(int code) {
		// TODO Auto-generated method stub
		ligneDAO.DeleteLigne(code);
	}

	@Override
	public List<Ligne> getAllLigne() {
		// TODO Auto-generated method stub
		return ligneDAO.getAllLigne();
	}


}
