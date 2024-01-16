package com.aca.pyrography.model;

public enum Difficulty {
	Beginner, Intermediate, Expert ,Artisan;
	
	public static Difficulty convertStringToDifficulty(String value) {
		Difficulty experience = null;
		for(Difficulty difficult : Difficulty.values()) {
			if(difficult.toString().equalsIgnoreCase(value)) {
				experience = difficult;
			}
		}
		return experience;
	}
}
