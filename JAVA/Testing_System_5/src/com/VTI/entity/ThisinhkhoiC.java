package com.VTI.entity;

public class ThisinhkhoiC extends Duthidaihoc{
	public ThisinhkhoiC(int sobaodanh, String hoten, String diachi, Mucuutien mucuutien) {
		super(sobaodanh, hoten, diachi, mucuutien);
		
	}
	private Monthi monthiC;
	private enum Monthi{
		VAN, SU, Dia
	}
}
