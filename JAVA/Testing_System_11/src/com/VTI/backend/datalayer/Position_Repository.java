package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VTI.entity.Position;
import com.VTI.ultis.ScannerUltis;
import com.VTI.ultis.jdbcUltis;

public class Position_Repository implements IPosition_Repository{
	private jdbcUltis jdbc;
	public Position_Repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	@Override
	public List<Position> getlistPositions() throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM db_connect.position;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Position> listpos = new ArrayList<Position>();
		while (resultSet.next()) {
			Position position = new Position(resultSet.getInt("PositionID"), resultSet.getString("PositionName"));
			listpos.add(position);
		}
		jdbc.disConnection();
		return listpos;
	}

	@Override
	public Position getPosByID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_connect.position WHERE PositionID = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Position position = new Position(resultSet.getInt("PositionID"), resultSet.getString("PositionName"));
			return position;
		}else {
			System.out.println("Không tìm được thông tin");
		}		return null;
	}

	@Override
	public boolean isPositionNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM db_connect.position WHERE PositionName = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}else {
			System.out.println("Không tìm thấy thông tin");
		}		return false;	
	}

	@Override
	public boolean createPosition(String name) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `db_connect`.`position` (`PositionName`) VALUES (?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
		if (preparedStatement.executeUpdate() == 1) {
			System.out.println("Tạo mới thành công");
			return true;
		}else {
			System.out.println("Không thể tạo mới. Mời kiểm tra lại");
			return false;
		}	
	}

	@Override
	public boolean updatePosition(int id, String newname) throws SQLException, ClassNotFoundException {
		Position positionID = getPosByID(id);
		if (positionID == null) {
			System.out.println("Dữ liệu không tồn tại");
			return false;
		}else {
			String sql = "UPDATE `db_connect`.`position` SET `PositionName` = ? WHERE (`PositionID` = ?);";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setString(1, newname);
			preparedStatement.setInt(2, id);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("Update thành công");
				return true;
			}else {
				System.out.println("Không thể update. Xin kiểm tra lại");
				return false;
			}
		}
	}

	@Override
	public boolean deletePosition(int id) throws ClassNotFoundException, SQLException {
		Position positionID = getPosByID(id);
		if (positionID == null) {
			System.out.println("Dữ liệu không tồn tại");
			return false;
		}else {
			String sql = "DELETE FROM `db_connect`.`position` WHERE (`PositionID` = ?);";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("Xóa thành công");
				return true;
			}else {
				System.out.println("Không thể xóa. Xin kiểm tra lại");
				return false;
			}
		}				
	}
	public String getname() {
		while (true) {
			switch (ScannerUltis.inputInt2()) {
			case 1:
				
				return "DEV";
			case 2:
				
				return "Test";
			case 3:
				
				return "Scrum Master";
			case 4:
				
				return "PM";
			default:
				
				break;
			}
		}		
	}
}
