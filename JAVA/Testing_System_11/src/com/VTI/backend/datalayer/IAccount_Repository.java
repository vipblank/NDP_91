package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Account;

public interface IAccount_Repository {
	public List<Account> getListAccount() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException;
	
	public Account getAccByID(int id) throws FileNotFoundException, IOException, SQLException, ClassNotFoundException;
	
	public boolean isAccountNameExists(String name) throws ClassNotFoundException, SQLException;
	
	public boolean createAccount(Account acc, int depId, int posId) throws SQLException, ClassNotFoundException;
	
	public boolean deleteAccount(int id) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	
	public boolean updateByEmail(int id, String newEmail) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	public boolean updateByUsername(int id, String Username) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	public boolean updateByFullname(int id, String Fullname) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException;
	
	public boolean updateByDepId(int id, int idDep) throws SQLException, ClassNotFoundException;
	
	public boolean updateByPosId(int id, int idPos) throws SQLException, ClassNotFoundException;
}
