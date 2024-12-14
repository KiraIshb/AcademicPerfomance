package com.example.AcademicPerfomance;
import java.util.ArrayList;
import java.util.Objects;

public class Group {
	private final String number;
	private double performance;
	public ArrayList<Student> Students;
	
	public Group(String number) {
		this.number = number;
		this.Students = new ArrayList<>();
	}
	public String getNumGroup() {
		return number;
	}
	public int getQuantity() {
		if (Students!=null)
			return Students.size();
		return 0;
	}
	public double getPerfomanse() {
		if (Objects.isNull(performance) & Students!=null) {
			double all = 0.0;
			for(Student a : Students) {
				all = all + a.getFinalScore();
			}
			performance = all/Students.size();
		}
		if (Objects.isNull(performance) & Students==null) {
			return 0;
		}
		return performance;
	}
	public void addStudent(Student st) {
		Students.add(st);
	}
	public String toString() {
		String result = "Группа " + number + ": " + "\n";
		if (Students!=null) {
			for (var a : Students) {
				result = result + a.toString() + "\n";
			}
			result = result + "\n";
		}
		return result;
	}
}
