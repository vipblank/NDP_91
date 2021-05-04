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
			this.monthi = "To�n, L�, Ho�";
			break;
		case "B":
			this.monthi = "To�n, Ho�, Sinh";
			break;
		case "C":
			this.monthi = "To�n, Ho�, Sinh";
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
