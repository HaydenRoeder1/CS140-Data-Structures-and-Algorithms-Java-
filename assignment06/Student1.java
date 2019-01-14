package assignment06;

import java.time.LocalDate;
import java.util.Comparator;

public class Student1 implements Comparable<Student1> {
	private Person1 individual;
	private double gpa;

	public Student1(String fstN, String lstN, long n, LocalDate d, double g) {
		individual = new Person1(fstN, lstN, n, d);
		gpa = g;
	}
	public double getGPA() {return gpa;}
	public int compareTo(Student1 arg0) {
		return individual.compareTo(arg0.individual);
	}

	public static Comparator<Student1> bySSN() {
		return new Comparator<Student1>() {			
				@Override
				public int compare(Student1 arg0,Student1 arg1) {
				if(arg0.individual.getSSN() < arg1.individual.getSSN()) {
					return -1;
				}else if(arg0.individual.getSSN() == arg1.individual.getSSN()) {
					return 0;
				}else {
					return 1;
				}
			}
		};
	}

	public static Comparator<Student1> byDOB() {
		return new Comparator<Student1>() {			
			@Override
			public int compare(Student1 arg0,Student1 arg1) {
				LocalDate dob1 = arg0.individual.getDOB();
				LocalDate dob2 = arg1.individual.getDOB();
				if(dob1.isBefore(dob2)) {
					return -1;
				}else if(dob1.isAfter(dob2)) {
					return 1;
				}else {
					return 0;
				}
			}
		};
	}

	public String toSSN() {
		return individual.toSSN();
	}
	
	public static Comparator<Student1> byGPA() {
		return new Comparator<Student1>() {			
				@Override
				public int compare(Student1 arg0,Student1 arg1) {
				if(arg0.getGPA() < arg1.getGPA()) {
					return -1;
				}else if(arg0.getGPA() == arg1.getGPA()) {
					return 0;
				}else {
					return 1;
				}
			}
		};	
	}
}
