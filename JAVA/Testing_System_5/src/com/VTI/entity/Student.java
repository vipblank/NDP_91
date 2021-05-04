package com.VTI.entity;

public class Student implements IStudent {
	public static int Count = 0;
	private int id;
	private String name;
	private int group;
	
	@Override
	public void DiemDanh() {
		System.out.println(name + " Đang điểm danh ");
		
	}
	@Override
	public void HocBai() {
		System.out.println(name + " Đang học bài ");
		
	}
	@Override
	public void DonVeSinh() {
		System.out.println(name + " Đang dọn vệ sinh ");
		
	}
	public Student(String name, int group) {
		Count++;
		this.id = Count;
		this.name = name;
		this.group = group;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getGroup() {
		return group;
	}
	
}
