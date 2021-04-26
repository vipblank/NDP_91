package com.VTI.entity;

public class Sach extends Tailieu{

	private String tacgia;
	private int sotrang;
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public int getSotrang() {
		return sotrang;
	}
	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}
	public Sach(int matailieu, String nhaxuatban, int sobanphathanh, String tacgia, int sotrang) {
		super(matailieu, nhaxuatban, sobanphathanh);
		this.tacgia = tacgia;
		this.sotrang = sotrang;
	}
	@Override
	public String toString() {
		return super.toString() + "Sach [tacgia=" + tacgia + ", sotrang=" + sotrang + "]";
	}
	
}
