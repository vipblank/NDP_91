package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.datalayer.Manager_Repository;
import com.VTI.entity.Manager;

public class Manager_Service implements IManager_Service{
	private Manager_Repository manager;
	public Manager_Service() throws FileNotFoundException, IOException {
		manager = new Manager_Repository();
	}
	@Override
	public boolean ManagerLogin(String email, String password) throws ClassNotFoundException, SQLException {
		
		return manager.ManagerLogin(email, password);
	}

	@Override
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException {
		
		return manager.GetListManager();
	}

	@Override
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException {
		
		return manager.GetManagerbyID(id);
	}

	@Override
	public Manager GetManagerbyName(String fullname) throws ClassNotFoundException, SQLException {
		
		return manager.GetManagerbyName(fullname);
	}

	@Override
	public boolean CreateManager(String fullname, String Email, String password, int ExplnYear)
			throws ClassNotFoundException, SQLException {
		if (manager.checkEmailAdmin(Email) || manager.checkEmailEmployee(Email) || manager.checkEmailManager(Email)) {
			System.err.println("Email này đã tồn tại. Tạo mới thất bại");
			return false;
		}
		return manager.CreateManager(fullname, Email, password, ExplnYear);
	}

}
