package academicPerformance;
import java.util.ArrayList;
import java.util.Objects;

public class Group {
	private final int number;
	private double perfomance;
	private ArrayList<Student> Students;
	
	public Group(int number) {
		this.number = number;
	}
	public int getNumGroup() {
		return number;
	}
	public int getQuantity() {
		if (Students!=null)
			return Students.size();
		return 0;
	}
	public double getPerfomanse() {
		if (Objects.isNull(perfomance) & Students!=null) {
			double all = 0.0;
			for(Student a : Students) {
				all = all + a.getFinalScore();
			}
			perfomance = all/Students.size();
		}
		if (Objects.isNull(perfomance) & Students==null) {
			return 0;
		}
		return perfomance;
	}
	public void addStudent(Student st) {
		Students.add(st);
	}
}