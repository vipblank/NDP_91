package com.VTI.entity;

public class Duthidaihoc {
	private int sobaodanh;
	private String hoten;
	private String diachi;
	private Mucuutien mucuutien;
	public enum Mucuutien{
		CAO,THAP
	}
	public Duthidaihoc(int sobaodanh, String hoten, String diachi, Mucuutien mucuutien) {
		super();
		this.sobaodanh = sobaodanh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.mucuutien = mucuutien;
	}
	public int getSobaodanh() {
		return sobaodanh;
	}
	public void setSobaodanh(int sobaodanh) {
		this.sobaodanh = sobaodanh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public Mucuutien getMucuutien() {
		return mucuutien;
	}
	public void setMucuutien(Mucuutien mucuutien) {
		this.mucuutien = mucuutien;
	}
	@Override
	public String toString() {
		return "Duthidaihoc [sobaodanh=" + sobaodanh + ", hoten=" + hoten + ", diachi=" + diachi + ", mucuutien="
				+ mucuutien + "]";
	}

}	
