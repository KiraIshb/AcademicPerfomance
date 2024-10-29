package academicPerformance;

public class Student {
	private final String fullName;
	private final int numGroup;
	private final String mark;
	
	public Student(String fullName, int numGroup, String mark) {
		this.fullName = fullName;
		this.numGroup = numGroup;
		this.mark = mark;
	}
	public double getFinalScore() {
		//метод будет находить итоговый балл, пока не знаю как
		return mark.length();
	}
	public int getNumGroup() {
		return numGroup;
	}
}
