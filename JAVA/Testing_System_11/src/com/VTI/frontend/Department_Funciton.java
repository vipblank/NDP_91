package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.VTI.backend.datalayer.Department_Repository;
import com.VTI.entity.Department;
import com.VTI.ultis.ScannerUltis;

public class Department_Funciton {
	
	public static void getlistDepartments() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Department_Repository department_Repository = new Department_Repository();
		List<Department> listdep = department_Repository.getlistDepartments();	
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
	public static void getDepByID() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Lấy thông tin department theo ID");
		System.out.println("Mời nhập vào ID");
		int id = ScannerUltis.inputInt2();
		Department_Repository department_Repository = new Department_Repository();
		Department department =  department_Repository.getDepByID(id);	
		if (department != null) {
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| DepartmentID  | DepartmentName     |%n");
			System.out.format("+---------------+--------------------+%n");	
			System.out.format(format1, department.getId(), department.getName());
			System.out.format("+---------------+--------------------+%n");	
		}
	}
	public static void isDepartmentNameExists() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Lấy thông tin department theo ID");
		Department_Repository department_Repository = new Department_Repository();
		Department department =  department_Repository.getDepByID(5);	
		if (department != null) {
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| DepartmentID  | DepartmentName     |%n");
			System.out.format("+---------------+--------------------+%n");	
			System.out.format(format1, department.getId(), department.getName());
			System.out.format("+---------------+--------------------+%n");	
		}
	}
	public static void createDepartment() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo department mới");
		System.out.println("Mời bạn nhập vào tên của department");
		String depname = ScannerUltis.inputString();
		Department_Repository department_Repository = new Department_Repository();
		if (department_Repository.isDepartmentNameExists(depname)) {
			System.out.println("department đã có trên hệ thống");
		}else {
			department_Repository.createDepartment(depname);
		}
	}
	public static void updateDepartmentName() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Update thông tin department");
		System.out.println("Mời nhập vào ID muốn update");
		int updateID = ScannerUltis.inputInt2();
		System.out.println("Mời nhập vào name để update");
		String updateName = ScannerUltis.inputString();
		Department_Repository department_Repository = new Department_Repository();
		if (department_Repository.isDepartmentNameExists(updateName)) {
			System.out.println("Tên phòng ban đã tồn tại");
		}else {
			department_Repository.updateDepartmentName(updateID, updateName);
			getlistDepartments();
		}
	}
	public static void deleteDepartment() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Delete thông tin department");
		System.out.println("Mời nhập vào ID muốn xóa");
		int deleteID = ScannerUltis.inputInt2();
		Department_Repository department_Repository = new Department_Repository();
		if (department_Repository.deleteDepartment(deleteID)) {
			System.out.println("Xóa thành công");
			getlistDepartments();
		}	
	}
}
