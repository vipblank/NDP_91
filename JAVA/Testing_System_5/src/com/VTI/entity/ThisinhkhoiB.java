package com.VTI.entity;

public class ThisinhkhoiB extends Duthidaihoc{
	public ThisinhkhoiB(int sobaodanh, String hoten, String diachi, Mucuutien mucuutien) {
		super(sobaodanh, hoten, diachi, mucuutien);
		
	}
	private Monthi monthiB;
	private enum Monthi{
		TOAN, HOA, SINH
	}
}
