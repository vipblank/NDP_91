package com.VTI.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.DAO.AccountDAO;
import com.VTI.DAO.DepartmentDAO;
import com.VTI.DAO.PositionDAO;
import com.VTI.entity.Account;
import com.VTI.entity.Department;
import com.VTI.entity.Position;
import com.VTI.ultis.ScannerUltis;

public class Exercise2_1 {
	public void question1() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		AccountDAO accountDAO = new AccountDAO();
		List<Account> listacc = accountDAO.getListAccount();
		System.out.println("Thông tin Account trên hệ thống");
		String format1 = "| %-10d | %-18s | %-13s | %-15s | %-12s | %-12s | %-18s |%n";
		System.out.format("+------------+--------------------+---------------+-----------------+--------------+--------------+--------------------+%n");
		System.out.format("| AccountID  | Email              | Username      | Fulname         | DepartmentID | PositionID   | CreateDate         |%n");
		System.out.format("+------------+--------------------+---------------+-----------------+--------------+--------------+--------------------+%n");	
		for (Account account : listacc) {
			System.out.format(format1, account.getId(), account.getEmail(), account.getUsername(), account.getFullname(),account.getDepartment(), account.getPosition(), account.getCreateDate());
		}
		System.out.format("+------------+--------------------+---------------+-----------------+--------------+--------------+--------------------+%n");
	}
	public void question2() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Lấy thông tin Account theo ID");
		System.out.println("Mời nhập vào ID");
		int id = ScannerUltis.inputInt2();
		AccountDAO accountDAO = new AccountDAO();
		Account account = accountDAO.getAccByID(id);
		if (account != null) {
			System.out.println("Thông tin Account trên hệ thống");
			String format1 = "| %-10d | %-18s | %-13s | %-15s | %-12s | %-12s | %-18s |%n";
			System.out.format("+------------+--------------------+---------------+-----------------+--------------+--------------+--------------------|%n");
			System.out.format("| AccountID  | Email              | Username      | Fulname         | DepartmentID | PositionID   | CreateDate         |%n");
			System.out.format("+------------+--------------------+---------------+-----------------+--------------+--------------+--------------------|%n");	
			System.out.format(format1, account.getId(), account.getEmail(), account.getUsername(), account.getFullname(),account.getDepartment(), account.getPosition(), account.getCreateDate());
			System.out.format("+------------+--------------------+---------------+-----------------+--------------+--------------+--------------------|%n");
		}
	}

	public void question3() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Kiểm tra thông tin Account theo name");
		System.out.println("Nhập vào tên Username muốn kiểm tra");
		String username = ScannerUltis.inputString();
		AccountDAO accountDAO = new AccountDAO();
		boolean check = accountDAO.isAccountNameExists(username);
		if (check) {
			System.out.println("Tên đã có trên hệ thống");
		}else {
			System.out.println("Tên chưa có trên hệ thống");
		}
	}
	public void question4() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo Account mới");
		Account account = new Account();
		System.out.println("Mời bạn nhập vào Email");
		account.setEmail(ScannerUltis.inputEmail());
		System.out.println("Mời bạn nhập vào Username");
		account.setUsername(ScannerUltis.inputString());
		System.out.println("Mời bạn nhập vào Fullname");
		account.setFullname(ScannerUltis.inputString());
		System.out.println("Mời chọn department theo ID");
		int chooseDepID = getDep();
		System.out.println("Mời chọn position theo ID");
		int choosePosID = getPos();		
		AccountDAO accountDAO = new AccountDAO();
		if (accountDAO.createAccount(account, chooseDepID, choosePosID)) {
			System.out.println("Tạo mới thành công");
			question1();
		}
	}
	
	private int getDep() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
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
			System.out.println("Mời chọn department theo ID");
			int depid = ScannerUltis.inputInt2();
			if (departmentDAO.getDepByID(depid) != null) {
				return depid;
			}		
		}	
	}
	
	private int getPos() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			PositionDAO positionDAO = new PositionDAO();
			List<Position> listPos = positionDAO.getlistPositions();
			System.out.println("Thông tin Position trên hệ thống");
			String format2 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| PositionID    | PositionName       |%n");
			System.out.format("+---------------+--------------------+%n");	
			for (Position position : listPos) {
				System.out.format(format2, position.getId(), position.getName());	
				}
			System.out.format("+---------------+--------------------+%n");
			System.out.println("Mời chọn position theo ID");
			int posid = ScannerUltis.inputInt2();
			if (positionDAO.getPosByID(posid) != null) {
				return posid;
			}	
		}
	}
	
	public void question5() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Update thông tin account");	
		while (true) {		
			System.out.println("+===============================================+");
			System.out.println("+============= Lựa Chọn Chức Năng ==============+");
			System.out.println("|       1: question 1: updateEmail              |");
			System.out.println("|       2: question 2: updateUsername           |");
			System.out.println("|       3: question 3: updateFullname           |");
			System.out.println("|       4: question 4: updateDepartmentID       |");
			System.out.println("|       5: question 5: updatePositionID         |");
			System.out.println("|       6: Thoát khỏi chương trình              |");
			System.out.println("+===============================================+");
			System.out.println("Chọn thông tin cần update");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				updateEmail();
				continue;
			case 2:
				updateUsername();
				continue;
			case 3:
				updateFullname();
				continue;
			case 4:
				updateDepartmentID();
				continue;
			case 5:
				updatePositionID();
				continue;
			case 6:
				
				return;
			default:
				break;
			}
		}
	}
	private void updatePositionID() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập vào accountID cần update");
		int updateid = ScannerUltis.inputInt2();
		System.out.println("Nhập vào DepartmentID muốn thay đổi");
		int newdpositionID = ScannerUltis.inputInt2();
		AccountDAO accountDAO = new AccountDAO();
		if (accountDAO.updateByPosId(updateid, newdpositionID)) {
			System.out.println("Update thành công");
			question1();
		}else {
			System.out.println("Update không thành công, xin kiểm tra lại");
		}
	}
	private void updateDepartmentID() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập vào accountID cần update");
		int updateid = ScannerUltis.inputInt2();
		System.out.println("Nhập vào DepartmentID muốn thay đổi");
		int newdepartmentID = ScannerUltis.inputInt2();
		AccountDAO accountDAO = new AccountDAO();
		if (accountDAO.updateByDepId(updateid, newdepartmentID)) {
			System.out.println("Update thành công");
			question1();
		}else {
			System.out.println("Update không thành công, xin kiểm tra lại");
		}	
	}
	private void updateFullname() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập vào accountID cần update");
		int updateid = ScannerUltis.inputInt2();
		System.out.println("Nhập vào Fullname muốn thay đổi");
		String newFullname = ScannerUltis.inputString();
		AccountDAO accountDAO = new AccountDAO();
		if (accountDAO.updateByFullname(updateid, newFullname)) {
			System.out.println("Update thành công");
			question1();
		}else {
			System.out.println("Update không thành công, xin kiểm tra lại");
		}	
	}
	private void updateUsername() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập vào accountID cần update");
		int updateid = ScannerUltis.inputInt2();
		System.out.println("Nhập vào Username muốn thay đổi");
		String newUsername = ScannerUltis.inputString();
		AccountDAO accountDAO = new AccountDAO();
		if (accountDAO.updateByUsername(updateid, newUsername)) {
			System.out.println("Update thành công");
			question1();
		}else {
			System.out.println("Update không thành công, xin kiểm tra lại");
		}	
	}
	private void updateEmail() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Nhập vào accountID cần update");
		int updateid = ScannerUltis.inputInt2();
		System.out.println("Nhập vào Email muốn thay đổi");
		String newemail = ScannerUltis.inputEmail();
		AccountDAO accountDAO = new AccountDAO();
		if (accountDAO.updateByEmail(updateid, newemail)) {
			System.out.println("Update thành công");
			question1();
		}else {
			System.out.println("Update không thành công, xin kiểm tra lại");
		}	
	}
	public void question6() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Delete thông tin Account");
		System.out.println("Mời nhập vào ID muốn xóa");
		int deleteID = ScannerUltis.inputInt2();
		AccountDAO accountDAO = new AccountDAO();
		if (accountDAO.deleteAccount(deleteID)) {
			System.out.println("Xóa thành công");
			question1();
		}
	}
}
