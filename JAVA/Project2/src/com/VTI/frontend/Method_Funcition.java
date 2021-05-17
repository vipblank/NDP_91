package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.VTI.backend.datalayer.Method_Repository;
import com.VTI.entity.Employee;
import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.entity.ProjectTeam;
import com.VTI.ultis.ScannerUltis;

public class Method_Funcition {

	public static void Login() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Đăng nhập tài khoản");
		System.out.println("Mời nhập vào email");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời nhập vào password");
		String password = ScannerUltis.inputPassword();
		Method_Repository methodRepository = new Method_Repository();
		if (methodRepository.AdminLogin(email, password)) {
			System.out.println("Đăng nhập quyền admin thành công");
			AdminWorks();
		} else if (methodRepository.EmployeeLogin(email, password)) {
			System.out.println("Đăng nhập quyền employee thành công");
			EmployeeWorks();
		} else if (methodRepository.ManagerLogin(email, password)) {
			System.out.println("Đăng nhập quyền manager thành công");
			ManagerWorks();
		}
	}

	public static void ProjectTeamInfor1()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID của project");
		int IDcheck = ScannerUltis.inputInt2();
		Method_Repository methodRepository = new Method_Repository();
		List<ProjectTeam> listPjTeam = methodRepository.ProjectTeamInfor1(IDcheck);
		if (listPjTeam != null) {
			System.out.println("Thông tin ProjectTeam trên hệ thống");
			String format1 = "| %-12d | %-12d | %-12s | %-12d | %-12s |%n";
			System.out.format("+--------------+--------------+--------------+--------------+--------------+%n");
			System.out.format("| ProjectID    | ManagerID    | MgName       | EmployeeID   | EpName       |%n");
			System.out.format("+--------------+--------------+--------------+--------------+--------------+%n");
			for (ProjectTeam projectTeam2 : listPjTeam) {
				System.out.format(format1, projectTeam2.getProject(), projectTeam2.getManager(),
						projectTeam2.getManager1(), projectTeam2.getEmployee(), projectTeam2.getEmployee1());
			}
			System.out.format("+--------------+--------------+--------------+--------------+--------------+%n");
		} else {
			System.err.println("Project chưa được khởi tạo.");
		}
	}

	public static void GetListEmployee()
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		Method_Repository methodRepository = new Method_Repository();
		List<Employee> listEp = methodRepository.GetListEmployee();
		if (listEp != null) {
			System.out.println("Thông tin Employee của Project");
			String format1 = "| %-10d | %-12s | %-16s | %-12s | %-10s |%n";
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			System.out.format("| EmployeeID | Fullname     | Email            | Password     | ProSkill   |%n");
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			for (Employee employee : listEp) {
				System.out.format(format1, employee.getId(), employee.getFullname(), employee.getEmail(),
						employee.getPassword(), employee.getProskill());
			}
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
		} else {
			System.err.println("Employee chưa có thông tin trên hệ thống");
		}
	}

	public static void GetListManager()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Method_Repository methodRepository = new Method_Repository();
		List<Manager> listMg = methodRepository.GetListManager();
		if (listMg != null) {
			System.out.println("Thông tin Manager trên hệ thống");
			String format1 = "| %-10d | %-12s | %-16s | %-12s | %-10d |%n";
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			System.out.format("| ManagerID  | Fullname     | Email            | Password     | ExplnYear  |%n");
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
			for (Manager manager : listMg) {
				System.out.format(format1, manager.getId(), manager.getFullname(), manager.getEmail(),
						manager.getPassword(), manager.getExplnYear());
			}
			System.out.format("+------------+--------------+------------------+--------------+------------+%n");
		} else {
			System.err.println("Manager chưa có thông tin trên hệ thống.");
		}
	}

	public static void GetListProject()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Method_Repository methodRepository = new Method_Repository();
		List<Project> listPj = methodRepository.GetListProject();
		if (listPj != null) {
			System.out.println("Thông tin Project trên hệ thống");
			String format1 = "| %-10d | %-12s | %-16s | %-10d |%n";
			System.out.format("+------------+--------------+------------------+------------+%n");
			System.out.format("| ProjectID  | ProjectName  | ProjectManagerID | TeamSize   |%n");
			System.out.format("+------------+--------------+------------------+------------+%n");
			for (Project project : listPj) {
				System.out.format(format1, project.getProjectID(), project.getProjectName(), project.getManager(),
						project.getTeamSize());
			}
			System.out.format("+------------+--------------+------------------+------------+%n");
		} else {
			System.err.println("Project chưa có thông tin trên hệ thống.");
		}
	}

	public static void CreateManager() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo Manager mới");
		System.out.println("Mời bạn nhập vào fullname");
		String fullname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Email theo định dạng: ...@vti.com.vn");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào password");
		String password = ScannerUltis.inputPassword();
		System.out.println("Mời bạn nhập vào ExplnYear");
		int explnYear = ScannerUltis.inputFunction(0, 10, "Mời nhập vào số");
		Method_Repository methodRepository = new Method_Repository();
		if (methodRepository.CreateManager(fullname, email, password, explnYear)) {
			System.out.println("Tạo mới thành công");
		}

	}

	public static void CreateEmployee()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Tạo Employee mới");
		System.out.println("Mời bạn nhập vào fullname");
		String fullname = ScannerUltis.inputFullname();
		System.out.println("Mời bạn nhập vào Email theo định dạng: ...@vti.com.vn");
		String email = ScannerUltis.inputEmail();
		System.out.println("Mời bạn nhập vào password");
		String password = ScannerUltis.inputPassword();
		System.out.println("Mời bạn nhập chọn Proskill: 1.Dev, 2.Test, 3.Scrum Master, 4.SQL");
		String proskill = getProskill();
		Method_Repository methodRepository = new Method_Repository();
		if (methodRepository.CreateEmployee(fullname, email, password, proskill)) {
			System.out.println("Tạo mới thành công");
		}

	}

	public static String getProskill() {
		while (true) {
			switch (ScannerUltis.inputInt2()) {
			case 1:

				return "Dev";
			case 2:

				return "Test";
			case 3:

				return "Scrum Master";
			case 4:

				return "SQL";
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	public static void CreateProject() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		System.out.println("Tạo Project mới");
		System.out.println("Mời bạn nhập vào ProjectName");
		String name = ScannerUltis.inputString();
		System.out.println("Mời bạn chọn Manager theo ID");
		int chooseID = getManagerID();
		System.out.println("Mời bạn nhập vào teamsize");
		int teamsize = ScannerUltis.inputInt2();
		Method_Repository methodRepository = new Method_Repository();
		if (methodRepository.CreateProject(name, chooseID, teamsize)) {
			System.out.println("Tạo mới thành công");
		}

	}

	public static int getManagerID() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			Method_Repository methodRepository = new Method_Repository();
			List<Manager> listMg = methodRepository.GetListManager();
			System.out.println("Thông tin Manager đang có trên hệ thống");
			String format1 = "| %-13d | %-18s |%n";
			System.out.format("+---------------+--------------------+%n");
			System.out.format("| ManagertID  | Fullname             |%n");
			System.out.format("+---------------+--------------------+%n");
			for (Manager manager : listMg) {
				System.out.format(format1, manager.getId(), manager.getFullname());
			}
			System.out.format("+---------------+--------------------+%n");
			System.out.println("Mời chọn Manager theo ID");
			int MgID = ScannerUltis.inputInt2();
			if (methodRepository.GetManagerbyID(MgID) != null) {
				return MgID;
			}
		}
	}

	public static void GetAllListPJ() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Method_Repository methodRepository = new Method_Repository();
		List<Project> listPj = methodRepository.GetManagerAtProject1();
		if (listPj != null) {
			System.out.println("Thông tin Project trên hệ thống");
			String format1 = "| %-10d | %-13s | %-10d | %-13s | %-10d |%n";
			System.out.format("+------------+---------------+------------+---------------+------------+%n");
			System.out.format("| ProjectID  | ProjectName   | ManagerID  | ManagerName   | TeamSize   |%n");
			System.out.format("+------------+---------------+------------+---------------+------------+%n");
			for (Project project : listPj) {
				System.out.format(format1, project.getProjectID(), project.getProjectName(), project.getManager(),
						project.getManager11(), project.getTeamSize());
			}
			System.out.format("+------------+---------------+-------------+--------------+------------+%n");
		} else {
			System.err.println("Project chưa có thông tin trên hệ thống.");
		}
	}

	private static void ManagerWorks() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Create Project                          |");
			System.out.println("|              2: Update Project                          |");
			System.out.println("|              3: Delete Project                          |");
			System.out.println("|              4: Getlist Project                         |");
			System.out.println("|              5: Check Manager At Project                |");
			System.out.println("|              6: Check ProjectTeam                       |");
			System.out.println("|              7: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Method_Funcition.CreateProject();
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				Method_Funcition.GetListProject();
				break;
			case 5:
				Method_Funcition.GetAllListPJ();
				break;
			case 6:
				Method_Funcition.ProjectTeamInfor1();
				break;
			case 7:

				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void EmployeeWorks()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Getlist Project                         |");
			System.out.println("|              2: Check ManagerInfo At Project            |");
			System.out.println("|              3: Check ProjectTeam                       |");
			System.out.println("|              4: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Method_Funcition.GetListProject();
				break;
			case 2:
				Method_Funcition.GetAllListPJ();
				break;
			case 3:
				Method_Funcition.ProjectTeamInfor1();
				break;
			case 4:

				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}

	private static void AdminWorks() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Getlist Manager                         |");
			System.out.println("|              2: Getlist Employee                        |");
			System.out.println("|              3: Create Manager                          |");
			System.out.println("|              4: Create Employee                         |");
			System.out.println("|              5: Update Manager                          |");
			System.out.println("|              6: Update Employee                         |");
			System.out.println("|              7: Detele Manager                          |");
			System.out.println("|              8: Delete Employee                         |");
			System.out.println("|              9: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				Method_Funcition.GetListManager();
				break;
			case 2:
				Method_Funcition.GetListEmployee();
				break;
			case 3:
				Method_Funcition.CreateManager();
				break;
			case 4:
				Method_Funcition.CreateEmployee();
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				return;
			default:
				System.err.println("Mời chọn lại");
				break;
			}
		}
	}
}