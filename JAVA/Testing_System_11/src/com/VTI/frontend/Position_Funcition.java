package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.VTI.backend.datalayer.Position_Repository;
import com.VTI.entity.Position;
import com.VTI.ultis.ScannerUltis;

public class Position_Funcition {
	public static void getlistPositions() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Position_Repository positionrepository = new Position_Repository();
		List<Position> listPos = positionrepository.getlistPositions();
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
	public static void getPosByID() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Lấy thông tin Position theo ID");
		System.out.println("Mời nhập vào ID");
		int id = ScannerUltis.inputInt2();
		Position_Repository positionrepository = new Position_Repository();
		Position position = positionrepository.getPosByID(id);
		if (position != null) {
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| PositionID    | PositionName       |%n");
			System.out.format("+---------------+--------------------+%n");	
			System.out.format(format1, position.getId(), position.getName());
			System.out.format("+---------------+--------------------+%n");
		}
	}
	public static void isPositionNameExists() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra thông tin Position theo name");
		System.out.println("Nhập vào tên Position muốn kiểm tra");
		String posname = ScannerUltis.inputString();
		Position_Repository positionrepository = new Position_Repository();
		boolean check = positionrepository.isPositionNameExists(posname);
		if (check) {
			System.out.println("Tên đã có trên hệ thống");
		}else {
			System.out.println("Tên chưa có trên hệ thống");
		}
	}
	public static void createPosition() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo position mới");
		System.out.println("Mời bạn lựa chọn position muốn tạo: 1.Dev, 2.Test, 3.Scrum Master, 4.PM");
		String name = ScannerUltis.inputString();
		Position_Repository positionrepository = new Position_Repository();
		positionrepository.createPosition(name);
		System.out.println("Tạo mới thành công");
		getlistPositions();
	}
	public static void updatePosition() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Update thông tin position");
		System.out.println("Mời nhập vào ID muốn update");
		int updateID = ScannerUltis.inputInt2();
		System.out.println("Mời nhập vào name để update");
		String updateName = ScannerUltis.inputString();
		Position_Repository positionrepository = new Position_Repository();
		if (positionrepository.updatePosition(updateID, updateName)) {
			System.out.println("Update thành công");
			getlistPositions();
		}
	}
	public static void deletePosition() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		System.out.println("Delete thông tin position");
		System.out.println("Mời nhập vào ID muốn xóa");
		int deleteID = ScannerUltis.inputInt2();
		Position_Repository positionrepository = new Position_Repository();
		if (positionrepository.deletePosition(deleteID)) {
			System.out.println("Xóa thành công");
			getlistPositions();
		}
	}
}
