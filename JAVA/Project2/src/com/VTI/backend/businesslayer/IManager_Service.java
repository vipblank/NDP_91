package com.VTI.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Manager;

public interface IManager_Service {
	
	public boolean ManagerLogin(String email, String password) throws ClassNotFoundException, SQLException;
	
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException;
	
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException;
	
	public Manager GetManagerbyName(String fullname) throws ClassNotFoundException, SQLException;
	
	public boolean CreateManager(String fullname, String Email, String password, int ExplnYear) throws ClassNotFoundException, SQLException;
}
