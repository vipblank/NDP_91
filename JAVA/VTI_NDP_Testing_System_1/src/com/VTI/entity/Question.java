package com.VTI.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Question {
	public int id;
	public String content;
	public Categoryquestion categoryQ;
	public Typequestion typeQ;
	public Account creator;
	public LocalDate createdate;
	public Exam[] exams;
	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", categoryQ=" + categoryQ + ", typeQ=" + typeQ
				+ ", creator=" + creator + ", createdate=" + createdate + ", exams=" + Arrays.toString(exams) + "]";
	}
	
}	
