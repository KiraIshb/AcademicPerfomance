package com.example.AcademicPerfomance;

public class Student {
	private final String fullName;
	private final String numGroup;
	private final int activity;
	private final int exercises;
	private final int homework;
	
	public Student(String fullName, String numGroup, int activity, int exercises, int homework) {
		this.fullName = fullName;
		this.numGroup = numGroup;
		this.activity = activity;
		this.exercises = exercises;
		this.homework = homework;
	}
	
        public String getFullName() {
		return fullName;
	}
        
	public String getNumGroup() {
		return numGroup;
	}
	
	public double getFinalScore() {
		return activity + exercises + homework;
	}
	
	public String toString() {
		return "Студент " + fullName + ", итоговый балл:" + getFinalScore();
	}
}
