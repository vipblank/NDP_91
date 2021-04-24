package com.VTI.entity;

public class Answer {
	public int id;
	public String content;
	public Question quesid;
	public Boolean isCorrect;
	@Override
	public String toString() {
		return "Answer [id=" + id + ", content=" + content + ", quesid=" + quesid + ", isCorrect=" + isCorrect + "]";
	}
	
}
