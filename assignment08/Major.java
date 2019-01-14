package assignment08;
import java.util.List;
import java.util.ArrayList;
public class Major {
	private String name;
	private List<Student> studentsInMajor;
	public String getName() {return name;}
	public List<Student> getStudents(){return studentsInMajor;}
	public Major(String n) {
		name = n;
		studentsInMajor = new ArrayList<>();
	}
	public void addStudent(Student s) {
		studentsInMajor.add(s);
	}
	public void setMajors() {
		studentsInMajor.stream().forEach(e -> e.setMajor(name));
	}

	
	
}
