package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Account;

public interface IAccount_Service {
	public List<Account> getListAccount() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	public Account getAccByID(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	public boolean isAccountNameExists(String name) throws ClassNotFoundException, SQLException;
	
	public boolean createAccount(Account acc, int depId, int posId) throws ClassNotFoundException, SQLException;
	
	public boolean deleteAccount(int id) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean updateByEmail(int id, String newEmail) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	public boolean updateByUsername(int id, String Username) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	public boolean updateByFullname(int id, String Fullname) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException;
	
	public boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException;
}
