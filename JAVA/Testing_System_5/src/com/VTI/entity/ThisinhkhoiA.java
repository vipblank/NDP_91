package com.VTI.entity;

public class ThisinhkhoiA extends Duthidaihoc{
	public ThisinhkhoiA(int sobaodanh, String hoten, String diachi, Mucuutien mucuutien) {
		super(sobaodanh, hoten, diachi, mucuutien);
		
	}
	private Monthi monthiA;
	private enum Monthi{
		TOAN, LY, HOA
	}
}
