package com.VTI.entity;

import java.util.ArrayList;

public class Duthidaihoc {
	public static int count = 0;
	private int sobaodanh;
	private String hoten;
	private String diachi;
	private Mucuutien mucuutien;
	private Khoithi khoithi;
	public enum Mucuutien{
		CAO,THAP
	}
	public Duthidaihoc( String hoten, String diachi, Mucuutien mucuutien, Khoithi khoithi) {
		count++;
		this.sobaodanh = count;
		this.hoten = hoten;
		this.diachi = diachi;
		this.mucuutien = mucuutien;
		this.khoithi = khoithi;
	}

	public int getSobaodanh() {
		return sobaodanh;
	}

	@Override
	public String toString() {
		return "Duthidaihoc [sobaodanh=" + sobaodanh + ", hoten=" + hoten + ", diachi=" + diachi + ", mucuutien="
				+ mucuutien + ", khoithi=" + khoithi.getMonthi() + "]";
	}


}	
