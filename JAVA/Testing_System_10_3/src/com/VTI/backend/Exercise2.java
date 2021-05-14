package com.VTI.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.VTI.DAO.DepartmentDAO;
import com.VTI.entity.Department;
import com.VTI.ultis.ScannerUltis;

public class Exercise2 {
	public void question1() throws ClassNotFoundException, SQLException, IOException {
		DepartmentDAO departmentDAO = new DepartmentDAO();
		List<Department> listdep = departmentDAO.getlistDepartments();	
		System.out.println("Thông tin department đang có trên hệ thống");
		String format1 = "| %-13d | %-18s |%n";
		System.out.format("+---------------+--------------------+%n");
		System.out.format("| DepartmentID  | DepartmentName     |%n");
		System.out.format("+---------------+--------------------+%n");	
		for (Department department : listdep) {
			System.out.format(format1, department.getId(), department.getName());			
		}
		System.out.format("+---------------+--------------------+%n");
	}
	public void question3() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Lấy thông tin department theo ID");
		System.out.println("Mời nhập vào ID");
		int id = ScannerUltis.inputInt2();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		Department department =  departmentDAO.getDepByID(id);	
		if (department != null) {
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| DepartmentID  | DepartmentName     |%n");
			System.out.format("+---------------+--------------------+%n");	
			System.out.format(format1, department.getId(), department.getName());
			System.out.format("+---------------+--------------------+%n");	
		}
	}
	public void question2() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Lấy thông tin department theo ID");
		DepartmentDAO departmentDAO = new DepartmentDAO();
		Department department =  departmentDAO.getDepByID(5);	
		if (department != null) {
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| DepartmentID  | DepartmentName     |%n");
			System.out.format("+---------------+--------------------+%n");	
			System.out.format(format1, department.getId(), department.getName());
			System.out.format("+---------------+--------------------+%n");	
		}
	}
	public void question4() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra thông tin department theo name");
		System.out.println("Nhập vào tên department muốn kiểm tra");
		String depname = ScannerUltis.inputString();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		boolean check =  departmentDAO.isDepartmentNameExists(depname);
		if (check) {
			System.out.println("Tên đã có trên hệ thống");
		}else {
			System.out.println("Tên chưa có trên hệ thống");
		}
	}
	public void question5() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo department mới");
		System.out.println("Mời bạn nhập vào tên của department");
		String depname = ScannerUltis.inputString();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		if (departmentDAO.isDepartmentNameExists(depname)) {
			System.out.println("department đã có trên hệ thống");
		}else {
			departmentDAO.createDepartment(depname);
		}
	}
	public void question6() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Update thông tin department");
		System.out.println("Mời nhập vào ID muốn update");
		int updateID = ScannerUltis.inputInt2();
		System.out.println("Mời nhập vào name để update");
		String updateName = ScannerUltis.inputString();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		if (departmentDAO.isDepartmentNameExists(updateName)) {
			System.out.println("Tên phòng ban đã tồn tại");
		}else {
			departmentDAO.updateDepartmentName(updateID, updateName);
			question1();
		}
	}
	public void question7() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Delete thông tin department");
		System.out.println("Mời nhập vào ID muốn xóa");
		int deleteID = ScannerUltis.inputInt2();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		if (departmentDAO.deleteDepartment(deleteID)) {
			System.out.println("Xóa thành công");
			question1();
		}	
	}
}

