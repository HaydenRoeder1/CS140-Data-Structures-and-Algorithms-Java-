package assignment08;
import java.util.List;
import java.util.stream.*;
import java.util.Comparator;
import java.util.ArrayList;
public class Tester {
	public static void main(String[] args) {
		List<Student> csMaj = new ArrayList<>();
		List<Student> mathMaj = new ArrayList<>();
		List<Student> physMaj = new ArrayList<>();
		Major cs = new Major("CS");
		Major physics = new Major("Physics");
		Major math = new Major("Math");
		List<Major> majors = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			csMaj.add(new Student("CSStudent" + i, i * 20));
			mathMaj.add(new Student("MathStudent" + i, i * 20));
			physMaj.add(new Student("PhysicsStudent" + i, i * 20));
		}
		for(Student s : csMaj) {
			cs.addStudent(s);
		}
		for(Student s : mathMaj) {
			math.addStudent(s);
		}
		for(Student s : physMaj) {
			physics.addStudent(s);
		}
		cs.setMajors();
		math.setMajors();
		physics.setMajors();
		majors.add(cs);
		majors.add(math);
		majors.add(physics);
		
		System.out.println(getSortedList(majors));
	}
	public static List<Student> getSortedList(List<Major> lst){
		Comparator<Student> comp = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.getNumCreditsCompleted() - s2.getNumCreditsCompleted();
			}
		};
		List<Student> retList = lst.stream().flatMap(e -> e.getStudents().stream()).collect(Collectors.toList());
		retList.sort(comp);
		return retList;
	}
}
