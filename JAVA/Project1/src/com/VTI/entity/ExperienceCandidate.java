package com.VTI.entity;

public class ExperienceCandidate extends Candidate{
	private int ExplnYear;
	private String ProSkill;
	
	public ExperienceCandidate(int id, String firstName, String lastName, String phoneNumber, String email,
			String password, int ExplnYear, String ProSkill) {
		super(id, firstName, lastName, phoneNumber, email, password);
			this.ExplnYear = ExplnYear;
			this.ProSkill = ProSkill;
	}
	
	public ExperienceCandidate() {
		
	}

	public int getExplnYear() {
		return ExplnYear;
	}

	public void setExplnYear(int explnYear) {
		ExplnYear = explnYear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	@Override
	public String toString() {
		return super.toString() +  "ExperienceCandidate [ExplnYear=" + ExplnYear + ", ProSkill=" + ProSkill + "]";
	}

}
