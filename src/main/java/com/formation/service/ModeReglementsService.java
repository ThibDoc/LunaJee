package com.formation.service;

import java.util.List;

import com.formation.entity.ModeReglements;

public interface ModeReglementsService {
	
	public void CreateModeReglements(ModeReglements modeReglements);
	
	public ModeReglements getModeReglements(int code);
	
	public void updateModeReglements(ModeReglements modeReglements);
	
	public void DeleteModeReglements(int code);
	
	public List<ModeReglements> getAllModeReglements();

}
