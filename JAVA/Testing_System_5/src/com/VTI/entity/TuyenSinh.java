package com.VTI.entity;

import java.util.ArrayList;
import java.util.Scanner;

import com.VTI.entity.Duthidaihoc.Mucuutien;

public class TuyenSinh implements ITuyenSinh {
	private ArrayList<Duthidaihoc> listHS;
	private Scanner sc;

	public void question1() {
		sc = new Scanner(System.in);
		listHS = new ArrayList<Duthidaihoc>();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("============== 1: Thêm mới thí sinh ====================");
			System.out.println("===== 2: Hiện thị thông tin của thí sinh và khối thi====");
			System.out.println("============ 3: Tìm kiếm theo số báo danh ==============");
			System.out.println("============ 4: Thoát khỏi chương trình ================");
			System.out.println("========================================================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				show();
				break;
			case 3:
				search();
				break;
			case 4:

				return;
			default:
				System.out.println("Xin mời chọn chức năng");
				break;
			}
		}
	}

	@Override
	public void add() {
		Duthidaihoc duthidaihoc = null;
		System.out.println("Mời nhập vào họ và tên");
		String addhoten = sc.next();
		System.out.println("Mời nhập vào địa chỉ");
		String adddiachi = sc.next();
		System.out.println("Mời nhập vào khối thi : A, B, C");
		String addkhoithi = sc.next();
		Khoithi khoithi = new Khoithi(addkhoithi);
		System.out.println("Mời nhập vào mức ưu tiên : 1.Cao, 2.Thap");
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			duthidaihoc = new Duthidaihoc(addhoten, adddiachi, Mucuutien.CAO, khoithi);

			break;
		case 2:
			duthidaihoc = new Duthidaihoc(addhoten, adddiachi, Mucuutien.THAP, khoithi);
			break;
		default:
			System.out.println("Mời nhập lại số");
			return;
		}
		listHS.add(duthidaihoc);
	}

	@Override
	public void show() {
		for (Duthidaihoc duthidaihoc : listHS) {
			System.out.println(duthidaihoc);
		}
	}

	@Override
	public void search() {
		System.out.println("Mời nhập vào số báo danh");
		int checkSBD = sc.nextInt();
		for (Duthidaihoc duthidaihoc : listHS) {
			if (duthidaihoc.getSobaodanh() == checkSBD) {
				System.out.println(duthidaihoc);
			}
		}
	}

}
