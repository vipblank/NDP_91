package com.VTI.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.VTI.backend.presentationlayer.Manager_ConTroller;
import com.VTI.backend.presentationlayer.ProjectTeam_ConTroller;
import com.VTI.backend.presentationlayer.Project_ConTroller;
import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.entity.ProjectTeam;
import com.VTI.ultis.ScannerUltis;

public class Manager_Funcition {
	public static void ManagerWorks() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		while (true) {
			System.out.println("Mời bạn lựa chọn chức năng");
			System.out.println("+================ Lựa Chọn Chức Năng =====================+");
			System.out.println("|              1: Create Project                          |");
			System.out.println("|              2: Update Project                          |");
			System.out.println("|              3: Delete Project                          |");
			System.out.println("|              4: Check Manager At Project                |");
			System.out.println("|              5: Check ProjectTeam By ID                 |");
			System.out.println("|              6: Check ProjectTeam By Name               |");
			System.out.println("|              7: Thoát khỏi chương trình                 |");
			System.out.println("+=========================================================+");
			int menu = ScannerUltis.inputInt2();
			switch (menu) {
			case 1:
				
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				GetAllListPJ();
				break;
			case 5:
				ProjectTeamInfor1();
				break;
			case 6:
				ProjectTeamInfor();
				break;
			case 7:

				return;
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
		Project_ConTroller projectC = new Project_ConTroller();
		if (projectC.CreateProject(name, chooseID, teamsize)) {
			System.out.println("Tạo mới thành công");
		}
	}
	public static int getManagerID() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		while (true) {
			Manager_ConTroller managerC = new Manager_ConTroller();
			List<Manager> listMg = managerC.GetListManager();
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
			if (managerC.GetManagerbyID(MgID) != null) {
				return MgID;
			}
		}
	}
	public static void GetAllListPJ() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		Project_ConTroller projectC = new Project_ConTroller();
		List<Project> listPj = projectC.GetManagerAtProject1();
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
	public static void ProjectTeamInfor1()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID của project");
		int IDcheck = ScannerUltis.inputInt2();
		ProjectTeam_ConTroller projectTeamC = new ProjectTeam_ConTroller();
		Project_ConTroller projectC = new Project_ConTroller();
		List<ProjectTeam> listPjTeam = projectTeamC.ProjectTeamInfor1(IDcheck);
		if (projectC.GetProjectbyID(IDcheck) != null) {
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
	public static void ProjectTeamInfor()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào Name của project");
		String PjName = ScannerUltis.inputString();
		ProjectTeam_ConTroller projectTeamC = new ProjectTeam_ConTroller();
		Project_ConTroller projectC = new Project_ConTroller();
		List<ProjectTeam> listPjTeam = projectTeamC.ProjectTeamInfor(PjName);
		if (projectC.GetProjectbyName(PjName) != null) {
			System.out.println("Thông tin ProjectTeam trên hệ thống");
			String format1 = "| %-12d | %-12s | %-12d | %-12s | %-12d | %-12s |%n";
			System.out.format("+--------------+--------------+--------------+--------------+--------------+--------------+%n");
			System.out.format("| ProjectID    | PjName       | ManagerID    | MgName       | EmployeeID   | EpName       |%n");
			System.out.format("+--------------+--------------+--------------+--------------+--------------+--------------+%n");
			for (ProjectTeam projectTeam2 : listPjTeam) {
				System.out.format(format1, projectTeam2.getProject(),projectTeam2.getProject1(), projectTeam2.getManager(),
						projectTeam2.getManager1(), projectTeam2.getEmployee(), projectTeam2.getEmployee1());
			}
			System.out.format("+--------------+--------------+--------------+--------------+--------------+--------------+%n");
		} else {
			System.err.println("Project chưa được khởi tạo.");
		}
	}
}
