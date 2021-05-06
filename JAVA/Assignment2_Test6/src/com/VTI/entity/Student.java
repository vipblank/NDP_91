package com.VTI.entity;

public class Student {
	private static int count;
	private int id;
	private float diemtoan;
	private float diemly;
	private float diemhoa;
	public Student(float diemtoan, float diemly, float diemhoa) {
		count++;
		this.id = count;
		this.diemtoan = diemtoan;
		this.diemly = diemly;
		this.diemhoa = diemhoa;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", diemtoan=" + diemtoan + ", diemly=" + diemly + ", diemhoa=" + diemhoa + "]";
	}
	public float getDiemtoan() {
		return diemtoan;
	}
	public float getDiemly() {
		return diemly;
	}
	public float getDiemhoa() {
		return diemhoa;
	}
	public int getId() {
		return id;
	}	
}	
