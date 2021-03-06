package com.VTI.entity;

public class FresherCandidate extends Candidate{
	public String graduationRank;
	public enum Rank{
		Excellence, Good, Fair, Poor
	}
	public Rank rank;
	public FresherCandidate() {
		
	}
	
	public FresherCandidate(int id, String firstName, String lastName, String phoneNumber, String email,
			String password, String graduationRank, Category category) {
		super(id, firstName, lastName, phoneNumber, email, password, category);
		this.graduationRank = graduationRank;
	}

	public String getGraduationRank() {
		
		return graduationRank;
	}


	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return super.toString() +  "FresherCandidate [graduationRank=" + graduationRank + "]";
	}
	
}
