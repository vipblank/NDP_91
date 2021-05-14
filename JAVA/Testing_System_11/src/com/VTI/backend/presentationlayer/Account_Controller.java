package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.IAccount_Service;
import com.VTI.backend.datalayer.Account_Repository;
import com.VTI.entity.Account;

public class Account_Controller implements IAccount_Service{
	private Account_Repository accountrepository;
	public Account_Controller() throws FileNotFoundException, IOException {
		accountrepository = new Account_Repository();
	}
	@Override
	public List<Account> getListAccount()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		return accountrepository.getListAccount();
	}
	@Override
	public Account getAccByID(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		return accountrepository.getAccByID(id);
	}
	@Override
	public boolean isAccountNameExists(String name) throws ClassNotFoundException, SQLException {

		return accountrepository.isAccountNameExists(name);
	}
	@Override
	public boolean createAccount(Account acc, int depId, int posId) throws ClassNotFoundException, SQLException {

		return accountrepository.createAccount(acc, depId, posId);
	}
	@Override
	public boolean deleteAccount(int id)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		return accountrepository.deleteAccount(id);
	}
	@Override
	public boolean updateByEmail(int id, String newEmail)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		return accountrepository.updateByEmail(id, newEmail);
	}
	@Override
	public boolean updateByUsername(int id, String Username)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {

		return accountrepository.updateByUsername(id, Username);
	}
	@Override
	public boolean updateByFullname(int id, String Fullname)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		return accountrepository.updateByFullname(id, Fullname);
	}
	@Override
	public boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException {

		return accountrepository.updateByDepId(id, idDep);
	}
	@Override
	public boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException {

		return accountrepository.updateByPosId(id, idPos);
	}
}
