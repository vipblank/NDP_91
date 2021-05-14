package com.VTI.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VTI.ultis.ScannerUltis;
import com.VTI.ultis.jdbcUltis;

public class Exercise1 {
	private static jdbcUltis jdbc;
	public Exercise1() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	public void question1() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {	
		System.out.println("Test kết nối");
		jdbc.connnectionTestting();
	}
	public void quesiton2() throws SQLException, ClassNotFoundException {
		String sql1 = "SELECT * FROM db_connect.position";
		ResultSet posResultSet = jdbc.executeQuery(sql1);	
		System.out.println("Thông tin position đang có trên hệ thống");
		String format1 = "| %-11d | %-21s |%n";
		System.out.format("+-------------+-----------------------+%n");
		System.out.format("| PositionID  | PositionName          |%n");
		System.out.format("+-------------+-----------------------+%n");					
		while (posResultSet.next()) {
			System.out.format(format1, posResultSet.getInt("PositionID"), posResultSet.getString("PositionName"));
		}
		System.out.format("+-------------+-----------------------+%n");
	}
	public void quesiton3() throws ClassNotFoundException, SQLException {
		System.out.println("Tạo Position mới");
		String sql = "INSERT INTO `db_connect`.`position` (`PositionName`) VALUES (?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		System.out.println("Chọn Position cần tạo: 1.Dev, 2.Test, 3.Scrum Master, 4.PM");
		String name = getName();
		preparedStatement.setString(1, name);
		if (preparedStatement.executeUpdate() == 1) {
			System.out.println("Tạo thành công");
		}else {
			System.out.println("Đã có lỗi trong quá trình tạo");
		}
	}
	public String getName() {
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
	public void question4() throws ClassNotFoundException, SQLException {
		System.out.println("Update thông tin Position");
		quesiton2();
		System.out.println("Chọn ID cần update");
		int ID = ScannerUltis.inputInt2();
		System.out.println("Chọn tên position cần Update: 1.Dev, 2.Test, 3.Scrum Master, 4.PM");
		String newname = getName();
		String sql = "UPDATE `db_connect`.`position` SET `PositionName` = ? WHERE (`PositionID` = ?);";
		PreparedStatement preparedStatement1 = jdbc.createPrepareStatement(sql);
		preparedStatement1.setString(1, newname);
		preparedStatement1.setInt(2, ID);
		if (preparedStatement1.executeUpdate() == 1) {
			System.out.println("Update thành công");
		}else {
			System.err.println("Có lỗi xảy ra");
		}
		
	}
	public void question5() throws ClassNotFoundException, SQLException {
		System.out.println("Xóa thông tin Position theo ID");
		quesiton2();
		System.out.println("Chọn ID cần xóa");
		int ID = ScannerUltis.inputInt2();
		String sql = "DELETE FROM `db_connect`.`position` WHERE (`PositionID` = ?);";
		PreparedStatement preparedStatement2 = jdbc.createPrepareStatement(sql);
		preparedStatement2.setInt(1, ID);
		if (preparedStatement2.executeUpdate() == 1) {
			System.out.println("Xóa thành công");
		}else {
			System.err.println("Đã có lỗi xảy ra");
		}
	}
}
