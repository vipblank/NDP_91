package com.VTI.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.VTI.entity.Canbo;
import com.VTI.entity.Nhanvien;
import com.VTI.entity.Canbo.Gioitinh;
import com.VTI.entity.Congnhan;
import com.VTI.entity.Kysu;

public class Exercise_5 {
	private Scanner sc;
	private ArrayList<Canbo> listCanbo;

	public void question2() {
		sc = new Scanner(System.in);
		listCanbo = new ArrayList<Canbo>();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("================ 1: Thêm mới cán bộ ====================");
			System.out.println("================ 2: Tìm kiếm theo họ tên ===============");
			System.out.println("===== 3: Hiện thị thông tin về danh sách các cán bộ ====");
			System.out.println("==== 4: Nhập vào tên của cán bộ và delete cán bộ đó ====");
			System.out.println("================ 5: Thoát khỏi chương trình=============");
			System.out.println("========================================================");
			int luachon = sc.nextInt();
			switch (luachon) {
			case 1:
				addCanbo();
				break;
			case 2:
				timkiem();
				break;
			case 3:
				danhsach();
				break;
			case 4:
				xoathongtin();
				break;
			case 5:

				return;
			}
		}
	}
	private void addCanbo() {
		System.out.println("========================================================");
		System.out.println("================ Lựa Chọn Chức Năng ====================");
		System.out.println("================ 1: Thêm mới Congnhan ==================");
		System.out.println("================ 2: Thêm mới Nhanvien ==================");
		System.out.println("================ 3: Thêm mới Kysu ======================");
		System.out.println("================ 4: Thoát khỏi chương trình=============");
		System.out.println("========================================================");
		int luachon1 = sc.nextInt();
		switch (luachon1) {
		case 1:
			addCongnhan();
			break;
		case 2:
			addNhanvien();
			break;
		case 3:
			addKisu();
			break;
		case 4:
			
			return;
		}
	}
	private void addCongnhan() {
		System.out.println("Nhập vào tên Congnhan");
		String addname = sc.next();
		System.out.println("Nhập vào tuổi Congnhan");
		int addtuoi = sc.nextInt();
		System.out.println("Nhập vào giới tính Congnhan : 1.Nam, 2.Nu, 3.Khac");
		int chongioitinh = sc.nextInt();
		Gioitinh gioitinh1;
		switch (chongioitinh) {
		case 1:
			gioitinh1 = Gioitinh.NAM;
			break;
		case 2:
			gioitinh1 = Gioitinh.NU;
			break;
		default:
			gioitinh1 = Gioitinh.KHAC;
			break;
		}
		System.out.println("Nhập vào địa chỉ Congnhan");
		String adddiachi = sc.next();
		System.out.println("Nhập vào cấp bậc Congnhan");
		int addbac = sc.nextInt();
		Canbo congnhan = new Congnhan(addname, addtuoi, gioitinh1, adddiachi, addbac);
		listCanbo.add(congnhan);
	}
	private void addKisu() {
		System.out.println("Nhập vào tên Kisu");
		String addname = sc.next();
		System.out.println("Nhập vào tuổi Kisu");
		int addtuoi = sc.nextInt();
		System.out.println("Nhập vào giới tính Kisu : 1.Nam, 2.Nu, 3.Khac");
		int chongioitinh = sc.nextInt();
		Gioitinh gioitinh1 = null;
		switch (chongioitinh) {
		case 1:
			gioitinh1 = Gioitinh.NAM;
			break;
		case 2:
			gioitinh1 = Gioitinh.NU;
			break;
		default:
			gioitinh1 = Gioitinh.KHAC;
			break;
		}
		System.out.println("Nhập vào địa chỉ Kisu");
		String adddiachi = sc.next();
		System.out.println("Nhập vào chuyên ngành kĩ sư");
		String addchuyenganh = sc.next();
		Canbo kisu = new Kysu(addname, addtuoi, gioitinh1, adddiachi, addchuyenganh);
		listCanbo.add(kisu);
	}
	private void addNhanvien() {
		System.out.println("Nhập vào tên Nhanvien");
		String addname = sc.next();
		System.out.println("Nhập vào tuổi Nhanvien");
		int addtuoi = sc.nextInt();
		System.out.println("Nhập vào giới tính Nhanvien : 1.Nam, 2.Nu, 3.Khac");
		int chongioitinh = sc.nextInt();
		Gioitinh gioitinh1 = null;
		switch (chongioitinh) {
		case 1:
			gioitinh1 = Gioitinh.NAM;
			break;
		case 2:
			gioitinh1 = Gioitinh.NU;
			break;
		default:
			gioitinh1 = Gioitinh.KHAC;
			break;
		}
		System.out.println("Nhập vào địa chỉ Nhanvien");
		String adddiachi = sc.next();
		System.out.println("Nhập vào công việc của nhân viên");
		String addcongviec = sc.next();
		Canbo nhanvien = new Nhanvien(addname, addtuoi, gioitinh1, adddiachi, addcongviec);
		listCanbo.add(nhanvien);
	}
	private void timkiem() {
		System.out.println("Nhập vào tên bạn muốn tìm kiếm");
		String findname = sc.next();
		for (Canbo canbo : listCanbo) {
			if (canbo.getHoten().equals(findname)) {
				System.out.println(canbo);			
			}
		}
	}
	private void danhsach() {
		System.out.println("========================================================");
		System.out.println("================ Lựa Chọn Chức Năng ====================");
		System.out.println("================ 1: In ra danh sách Congnhan============");
		System.out.println("================ 2: In ra danh sách Nhanvien ===========");
		System.out.println("================ 3: In ra danh sách Kysu ===============");
		System.out.println("================ 4: Thoát khỏi chương trình=============");
		System.out.println("========================================================");
		int luachon1 = sc.nextInt();
		switch (luachon1) {
		case 1:
			for (Canbo canbo : listCanbo) {
				if (canbo instanceof Congnhan) {
					System.out.println(canbo);;
				}
			}	
			
			break;
		case 2:
			for (Canbo canbo : listCanbo) {
				if (canbo instanceof Nhanvien) {
					System.out.println(canbo);
				}
			}
			
			break;
		case 3:
			for (Canbo canbo : listCanbo) {
				if (canbo instanceof Kysu) {
					System.out.println(canbo);
				}
			}		
			break;
		case 4:		
			return;	
			}
		}	
	private void xoathongtin() {
		System.out.println("Nhập vào tên bạn muốn xóa");
		String deletename = sc.next();
		Iterator<Canbo> iterator = listCanbo.iterator();
		while (iterator.hasNext()) {
			Canbo canbo = (Canbo) iterator.next();
			if (canbo.getHoten().equals(deletename)) {
				iterator.remove();
			}
		}	
	}	
	
}

