package com.formation.service;

import java.util.List;

import com.formation.entity.Ligne;

public interface LigneService {
	
	public void CreateLigne(Ligne ligne);
	
	public Ligne getLigne(int code);
	
	public void updateLigne(Ligne ligne);
	
	public void DeleteLigne(int code);
	
	public List<Ligne> getAllLigne();
	
	public void deleteAllLigneComm(int code);

}
