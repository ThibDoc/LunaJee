package com.formation.daos;

import java.util.List;

import com.formation.entity.ModeReglements;

public interface ModeReglementsDAO {
	
	public void CreateModeReglements(ModeReglements modeReglements);
	
	public ModeReglements getModeReglements(int code);
	
	public void updateModeReglements(ModeReglements modeReglements);
	
	public void DeleteModeReglements(int code);
	
	public List<ModeReglements> getAllModeReglements();

}
