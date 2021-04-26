package com.VTI.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private Float score;
	public Student(String name, String hometown) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.score = 0f;
	}
	public void setScore(Float addScore) {
		this.score = addScore;
		
	}
 	public void bonusScore() {
 		Float point1 = null;
		this.score = this.score + point1;
	}
	public String getName() {
		return name;
	}
	public Float getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", hometown=" + hometown + ", score=" + score + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
 	
}
