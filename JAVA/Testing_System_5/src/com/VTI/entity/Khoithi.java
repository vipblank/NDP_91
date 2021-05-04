package com.VTI.entity;

public class Khoithi {
	private String name;
	private String monthi;

	public Khoithi(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getMonthi() {
		
		switch (this.name) {
		case "A":
			this.monthi = "Toán, Lý, Hoá";
			break;
		case "B":
			this.monthi = "Toán, Hoá, Sinh";
			break;
		case "C":
			this.monthi = "Toán, Hoá, Sinh";
			break;
		default:
			break;
		}
		return monthi;
	}

	@Override
	public String toString() {
		return "Khoithi [name=" + name + ", monthi=" + monthi + "]";
	}


}
