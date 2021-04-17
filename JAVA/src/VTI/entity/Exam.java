package com.VTI.entity;

import java.time.LocalDate;

public class Exam {
	public int id;
	public String code;
	public String title;
	public Categoryquestion categoryid;
	public int duration;
	public Account creator;
	public LocalDate createdate;
	public Question[] questions;
}
