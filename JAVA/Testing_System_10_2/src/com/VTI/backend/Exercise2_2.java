package com.VTI.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VTI.DAO.DepartmentDAO;
import com.VTI.DAO.PositionDAO;
import com.VTI.entity.Department;
import com.VTI.entity.Position;
import com.VTI.ultis.ScannerUltis;

public class Exercise2_2 {
	public void question1() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		PositionDAO positionDAO = new PositionDAO();
		List<Position> listPos = positionDAO.getlistPositions();
		System.out.println("Thông tin Position trên hệ thống");
		String format1 = "| %-13d | %-18s |%n";
		System.out.format("+---------------+--------------------+%n");
		System.out.format("| PositionID    | PositionName       |%n");
		System.out.format("+---------------+--------------------+%n");	
		for (Position position : listPos) {
			System.out.format(format1, position.getId(), position.getName());	
			}
		System.out.format("+---------------+--------------------+%n");
	}
	public void question2() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Lấy thông tin Position theo ID");
		System.out.println("Mời nhập vào ID");
		int id = ScannerUltis.inputInt2();
		PositionDAO positionDAO = new PositionDAO();
		Position position = positionDAO.getPosByID(id);
		if (position != null) {
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| PositionID    | PositionName       |%n");
			System.out.format("+---------------+--------------------+%n");	
			System.out.format(format1, position.getId(), position.getName());
			System.out.format("+---------------+--------------------+%n");
		}
	}
	public void question3() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Lấy thông tin Position theo ID");
		PositionDAO positionDAO = new PositionDAO();
		Position position = positionDAO.getPosByID(1);	
		if (position != null) {
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| PositionID    | PositionName       |%n");
			System.out.format("+---------------+--------------------+%n");	
			System.out.format(format1, position.getId(), position.getName());
			System.out.format("+---------------+--------------------+%n");	
		}
	}
	public void question4() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra thông tin Position theo name");
		System.out.println("Nhập vào tên Position muốn kiểm tra");
		String posname = ScannerUltis.inputString();
		PositionDAO positionDAO = new PositionDAO();
		boolean check = positionDAO.isPositionNameExists(posname);
		if (check) {
			System.out.println("Tên đã có trên hệ thống");
		}else {
			System.out.println("Tên chưa có trên hệ thống");
		}
	}
	public void question5() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo position mới");
		System.out.println("Mời bạn lựa chọn position muốn tạo: 1.Dev, 2.Test, 3.Scrum Master, 4.PM");
		String name = ScannerUltis.inputString();
		PositionDAO positionDAO = new PositionDAO();
		positionDAO.createPosition(name);
		System.out.println("Tạo mới thành công");
		question1();
	}
	public void question6() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Update thông tin position");
		System.out.println("Mời nhập vào ID muốn update");
		int updateID = ScannerUltis.inputInt2();
		System.out.println("Mời nhập vào name để update");
		String updateName = ScannerUltis.inputString();
		PositionDAO positionDAO = new PositionDAO();
		if (positionDAO.isPositionNameExists(updateName)) {
			System.out.println("Tên phòng ban đã tồn tại");
		}else {
			positionDAO.updatePosition(updateID, updateName);
			question1();
		}
	}
	public void question7() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Delete thông tin position");
		System.out.println("Mời nhập vào ID muốn xóa");
		int deleteID = ScannerUltis.inputInt2();
		PositionDAO positionDAO = new PositionDAO();
		if (positionDAO.deletePosition(deleteID)) {
			System.out.println("Xóa thành công");
			question1();
		}
	}
}
