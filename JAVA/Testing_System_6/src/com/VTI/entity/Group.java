package com.VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

import com.VTI.ultis.ScannerUltis;

public class Group {
	public static int count;
	private int id;
	private String name;
	private Account creator;
	private LocalDate CreateDate;
	public Account[] accounts;
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", CreateDate=" + CreateDate
				+ ", accounts=" + Arrays.toString(accounts) + "]";
	}
	public Group() {
		System.out.println("Mời nhập thông tin group");
		this.id = count;
		count++;
		System.out.println("Mời nhập tên group");
		this.name = ScannerUltis.inputString();
		System.out.println("Mời nhập ngày tạo group theo định dạng: yyyy-MM-dd");
		CreateDate = ScannerUltis.inputLocalDate();
		System.out.println("Bạn có muốn thêm account vào group hay không : 1.Có, 2.Không");
		while (true) {
			int addaccount = ScannerUltis.inputInt2();
			switch (addaccount) {
			case 1:
				System.out.println("Nhập số lượng account muốn thêm vào group");
				int addacc = ScannerUltis.inputInt();
				Account[] accounts = new Account[addacc];
				for (int i = 0; i < addacc; i++) {
					System.out.println("Nhập vào account thứ : " + (i + 1) );
					Account acc = new Account();
					accounts[i] = acc;
				}
				this.accounts = accounts;
				return;
			case 2:
				
				return;
			default:
				System.err.println("Mời nhập lại");
				break;
			}
		}
	}
	
}
