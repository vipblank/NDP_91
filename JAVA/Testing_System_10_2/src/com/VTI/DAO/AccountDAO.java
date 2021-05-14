package com.VTI.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.VTI.entity.Account;
import com.VTI.entity.Department;
import com.VTI.entity.Position;
import com.VTI.ultis.jdbcUltis;

public class AccountDAO {
	private static jdbcUltis jdbc;

	public AccountDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	public List<Account> getListAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM db_connect.account;";
		ResultSet accResultSet = jdbc.executeQuery(sql);
		List<Account> listacc = new ArrayList<Account>();
		while (accResultSet.next()) {
			Account account = new Account();
			account.setId(accResultSet.getInt(1));
			account.setEmail(accResultSet.getString(2));
			account.setUsername(accResultSet.getString(3));
			account.setFullname(accResultSet.getNString(4));

			DepartmentDAO departmentDAO = new DepartmentDAO();
			Department department = departmentDAO.getDepByID(accResultSet.getInt(5));
			account.setDepartment(department);

			PositionDAO positionDAO = new PositionDAO();
			Position position = positionDAO.getPosByID(accResultSet.getInt(6));
			account.setPosition(position);

			LocalDate localDate = accResultSet.getDate(7).toLocalDate();
			account.setCreateDate(localDate);
			listacc.add(account);
		}
		return listacc;
	}

	public Account getAccByID(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM DB_connect.account WHERE AccountID = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Account account = new Account();
			account.setId(resultSet.getInt(1));
			account.setEmail(resultSet.getString(2));
			account.setUsername(resultSet.getString(3));
			account.setFullname(resultSet.getNString(4));

			DepartmentDAO departmentDAO = new DepartmentDAO();
			Department department = departmentDAO.getDepByID(resultSet.getInt(5));
			account.setDepartment(department);

			PositionDAO positionDAO = new PositionDAO();
			Position position = positionDAO.getPosByID(resultSet.getInt(6));
			account.setPosition(position);

			LocalDate localDate = resultSet.getDate(7).toLocalDate();
			account.setCreateDate(localDate);
			return account;
		} else {
			System.out.println("Không tìm được");
			jdbc.disConnection();
			return null;
		}
	}

	public boolean isAccountNameExists(String name) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM DB_connect.account WHERE Username = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean createAccount(Account acc, int depId, int posId) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `db_connect`.`account` (`Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`) VALUES (?, ?, ? , ?, ?, now());";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, acc.getEmail());
		preparedStatement.setString(2, acc.getUsername());
		preparedStatement.setString(3, acc.getFullname());
		preparedStatement.setInt(4, depId);
		preparedStatement.setInt(5, posId);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			jdbc.disConnection();
			return true;
		} else {
			System.out.println("Không thể tạo mới. Mời kiểm tra lại");
			jdbc.disConnection();
			return false;
		}
	}

	public boolean deleteAccount(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account accountID = getAccByID(id);
		if (accountID == null) {
			System.out.println("Phòng ban chưa được khởi tạo");
			return false;
		} else {
			String sql = "DELETE FROM `db_connect`.`account` WHERE (`AccountID` = ?);";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("Delete thành công");
				return true;
			} else {
				System.out.println("Không thể Delete. Xin kiểm tra lại");
				jdbc.disConnection();
				return false;
			}
		}
	}

	public boolean updateByEmail(int id, String newEmail)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account accountID = getAccByID(id);
		if (accountID == null) {
			return false;
		}
		String sql = "UPDATE `db_connect`.`account` SET `Email` = ? WHERE (`AccountID` = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, newEmail);
		preparedStatement.setInt(2, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean updateByUsername(int id, String Username)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account accountID = getAccByID(id);
		if (accountID == null) {
			return false;
		}
		String sql = "UPDATE `db_connect`.`account` SET `Username` = ? WHERE (`AccountID` = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, Username);
		preparedStatement.setInt(2, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean updateByFullname(int id, String Fullname)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Account accountID = getAccByID(id);
		if (accountID == null) {
			return false;
		}
		String sql = "UPDATE `db_connect`.`account` SET `FullName` = ? WHERE (`AccountID` = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, Fullname);
		preparedStatement.setInt(2, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public boolean updateByDepId(int id, int idDep) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `db_connect`.`account` SET `DepartmentID` = ? WHERE (`AccountID` = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, idDep);
		preparedStatement.setInt(2, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateByPosId(int id, int idPos) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE `db_connect`.`account` SET `PositionID` = ? WHERE (`AccountID` = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, idPos);
		preparedStatement.setInt(2, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
}
