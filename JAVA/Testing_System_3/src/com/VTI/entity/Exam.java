package com.VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Exam {
	public int id;
	public String code;
	public String title;
	public Categoryquestion categoryid;
	public int duration;
	public Account creator;
	public LocalDate createdate;
	public Question[] questions;
	@Override
	public String toString() {
		return "Exam [id=" + id + ", code=" + code + ", title=" + title + ", categoryid=" + categoryid + ", duration="
				+ duration + ", creator=" + creator + ", createdate=" + createdate + ", questions="
				+ Arrays.toString(questions) + "]";
	}
	
}
