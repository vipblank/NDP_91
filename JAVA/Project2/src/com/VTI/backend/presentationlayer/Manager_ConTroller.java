package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.IManager_Service;
import com.VTI.backend.businesslayer.Manager_Service;
import com.VTI.entity.Manager;

public class Manager_ConTroller implements IManager_Service{
	private Manager_Service managerS;
	public Manager_ConTroller() throws FileNotFoundException, IOException {
		managerS = new Manager_Service();
	}
	@Override
	public boolean ManagerLogin(String email, String password) throws ClassNotFoundException, SQLException {
		
		return managerS.ManagerLogin(email, password);
	}

	@Override
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException {
	
		return managerS.GetListManager();
	}

	@Override
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException {
		
		return managerS.GetManagerbyID(id);
	}

	@Override
	public Manager GetManagerbyName(String fullname) throws ClassNotFoundException, SQLException {
		
		return managerS.GetManagerbyName(fullname);
	}

	@Override
	public boolean CreateManager(String fullname, String Email, String password, int ExplnYear)
			throws ClassNotFoundException, SQLException {
		
		return managerS.CreateManager(fullname, Email, password, ExplnYear);
	}
	
}
