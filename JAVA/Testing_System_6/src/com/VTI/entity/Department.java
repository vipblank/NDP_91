package com.VTI.entity;

import java.util.Scanner;

import com.VTI.ultis.ScannerUltis;

public class Department {
	private int id;
	private String name;
	public int count;
	private Scanner sc;
	public Department() throws Exception {
		sc = new Scanner(System.in);
		count++;
		this.id = count;
		this.name = inputname();
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private String inputname () throws Exception {
		try {
			System.out.println("Mời nhập vào tên");
			String addname = ScannerUltis.inputString();
			return addname;
			
		} catch (Exception e) {
			throw new Exception("Mời nhập vào tên");
		}
	}
}
