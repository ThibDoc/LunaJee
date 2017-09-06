package com.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.formation.daos.ModeReglementsDAO;
import com.formation.daos.ModeReglementsDAOImpl;
import com.formation.entity.ModeReglements;

@Repository("ModeReglementsService")
public class ModeReglementsServiceImpl implements ModeReglementsService {
	@Autowired
	private ModeReglementsDAO modeReglementsDAO;

	@Override
	public void CreateModeReglements(ModeReglements modeReglements) {
		// TODO Auto-generated method stub
		modeReglementsDAO.CreateModeReglements(modeReglements);
	}

	@Override
	public ModeReglements getModeReglements(int code) {
		// TODO Auto-generated method stub
		return modeReglementsDAO.getModeReglements(code);
	}

	@Override
	public void updateModeReglements(ModeReglements modeReglements) {
		// TODO Auto-generated method stub
		modeReglementsDAO.updateModeReglements(modeReglements);
	}

	@Override
	public void DeleteModeReglements(int code) {
		// TODO Auto-generated method stub
		modeReglementsDAO.DeleteModeReglements(code);
	}

	@Override
	public List<ModeReglements> getAllModeReglements() {
		// TODO Auto-generated method stub
		return modeReglementsDAO.getAllModeReglements();
	}


}
