package assignment06;

import java.time.LocalDate;
import java.util.Comparator;

public class Student implements Comparable<Student> {
	private Person individual;
	private double gpa;

	public Student(String fstN, String lstN, long n, LocalDate d, double g) {
		individual = new Person(fstN, lstN, n, d);
		gpa = g;
	}

	public int compareTo(Student arg0) {
		return individual.compareTo(arg0.individual);
	}

	public static Comparator<Student> bySSN() {
		return (s1, s2) -> Person.bySSN().compare(s1.individual, s2.individual);
	}

	public static Comparator<Student> byDOB() {
		return (s1, s2) -> Person.byDOB().compare(s1.individual, s2.individual);
	}

	public String toSSN() {
		return individual.toSSN();
	}
	
	public static Comparator<Student> byGPA() {
		return Comparator.comparingDouble(s -> s.gpa);
	}	
}
