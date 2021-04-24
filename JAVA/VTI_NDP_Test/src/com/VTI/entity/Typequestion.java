package com.VTI.entity;

public class Typequestion {
	public int id;
	public enum Typename{
		EASY, MULTI_CHOICE;
	}
	@Override
	public String toString() {
		return "Typequestion [id=" + id + "]";
	};
	
}

