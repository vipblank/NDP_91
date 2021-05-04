package com.VTI.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.VTI.entity.Bao;
import com.VTI.entity.Sach;
import com.VTI.entity.Tailieu;
import com.VTI.entity.Tapchi;

public class Exercise7_Ex4_Q4 {
	public static int matailieu = 0;
	private Scanner sc;
	private ArrayList<Tailieu> listTailieu;

	public void question4() {
		sc = new Scanner(System.in);
		listTailieu = new ArrayList<Tailieu>();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("      	      1: Thêm mới tài liêu       		        ");
			System.out.println("      	      2: Xoá tài liệu theo mã tài liệu		    ");
			System.out.println("      	      3: Hiện thị thông tin về tài liệu 		");
			System.out.println("      	      4: Tìm kiếm tài liệu theo loại 		    ");
			System.out.println("     	      5: Thoát khỏi chương trình.			    ");
			System.out.println("========================================================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				addTailieu();
				break;
			case 2:
				deleteTailieu();
				break;
			case 3:
				showTailieu();
				break;
			case 4:
				searchTailieu();
				break;
			case 5:

				return;
			default:
				System.out.println("Mời bạn lựa chọn chức năng");
				break;
			}
		}
	}

	public void addTailieu() {
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("      	      1: Thêm mới sách       		            ");
			System.out.println("      	      2: Thêm mới báo		                    ");
			System.out.println("      	      3: Thêm mới tạp chí 		                ");
			System.out.println("     	      4: Thoát khỏi chương trình.			    ");
			System.out.println("========================================================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Mời bạn nhập vào nhà xuất bản");
				String addNXB = sc.next();
				System.out.println("Mời bạn nhập vào số bản phát hành");
				int addSBPH = sc.nextInt();
				System.out.println("Mời bạn nhập vào tác giả");
				String addTG = sc.next();
				System.out.println("Mời bạn nhập vào số trang");
				int addtrang = sc.nextInt();
				matailieu++;
				Tailieu sach = new Sach(matailieu, addNXB, addSBPH, addTG, addtrang);
				listTailieu.add(sach);
				break;
			case 2:
				System.out.println("Mời bạn nhập vào nhà xuất bản");
				String addNXB1 = sc.next();
				System.out.println("Mời bạn nhập vào số bản phát hành");
				int addSBPH1 = sc.nextInt();
				System.out.println("Mời bạn nhập vào ngày phát hành");
				int day = sc.nextInt();
				System.out.println("Mời bạn nhập vào tháng phát hành");
				int month = sc.nextInt();
				System.out.println("Mời bạn nhập vào năm phát hành");
				int year = sc.nextInt();
				LocalDate addNPH = LocalDate.of(year, month, day);
				matailieu++;
				Tailieu bao = new Bao(matailieu, addNXB1, addSBPH1, addNPH);
				break;
			case 3:
				System.out.println("Mời bạn nhập vào nhà xuất bản");
				String addNXB2 = sc.next();
				System.out.println("Mời bạn nhập vào số bản phát hành");
				int addSBPH2 = sc.nextInt();
				System.out.println("Mời bạn nhập vào số phát hành");
				int addSPH = sc.nextInt();
				System.out.println("Mời bạn nhập vào ngày phát hành");
				int day1 = sc.nextInt();
				System.out.println("Mời bạn nhập vào tháng phát hành");
				int month1 = sc.nextInt();
				System.out.println("Mời bạn nhập vào năm phát hành");
				int year1 = sc.nextInt();
				LocalDate addNPH1 = LocalDate.of(year1, month1, day1);
				matailieu++;
				Tailieu tapchi = new Tapchi(matailieu, addNXB2, addSBPH2, addSPH, addNPH1);
				listTailieu.add(tapchi);
				break;
			case 4:

				return;
			default:
				System.out.println("Mời bạn lựa chọn chức năng");
				break;
			}
		}
	}

	public void deleteTailieu() {
		System.out.println("Nhập vào mã tài liệu bạn muốn xóa");
		int deletecode = sc.nextInt();
		Iterator<Tailieu> iterator = listTailieu.iterator();
		while (iterator.hasNext()) {
			Tailieu tailieu2 = (Tailieu) iterator.next();
			if (tailieu2.getMatailieu() == deletecode) {
				iterator.remove();
			}
		}
	}

	public void showTailieu() {
		for (Tailieu tailieu : listTailieu) {
			System.out.println(tailieu);
		}
	}

	public void searchTailieu() {
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("      	      1: Tìm thông tin sách       		        ");
			System.out.println("      	      2: Tìm thông tin báo		                ");
			System.out.println("      	      3: Tìm thông tin tạp chí 		            ");
			System.out.println("     	      4: Thoát khỏi chương trình.			    ");
			System.out.println("========================================================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				for (Tailieu tailieu : listTailieu) {
					if (tailieu instanceof Sach) {
						System.out.println(tailieu);
					}
				}
				break;
			case 2:
				for (Tailieu tailieu : listTailieu) {
					if (tailieu instanceof Bao) {
						System.out.println(tailieu);
					}
				}
				break;
			case 3:
				for (Tailieu tailieu : listTailieu) {
					if (tailieu instanceof Tapchi) {
						System.out.println(tailieu);
					}
				}
				break;
			case 4:

				return;
			default:
				System.out.println("Mời bạn lựa chọn chức năng");
				break;
			}
		}
	}
}
