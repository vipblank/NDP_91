package com.VTI.entity;

import java.time.LocalDate;

public class Question {
	public int id;
	public String content;
	public Categoryquestion categoryQ;
	public Typequestion typeQ;
	public Account creator;
	public LocalDate createdate;
	public Exam[] exam;
}	
