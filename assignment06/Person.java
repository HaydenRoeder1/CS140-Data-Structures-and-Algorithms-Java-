package assignment06;

import java.time.LocalDate;
import java.util.Comparator;

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	private long ssn;
	private LocalDate dob;

	public Person(String fstN, String lstN, long n, LocalDate d) {
		firstName = fstN;
		lastName = lstN;
		ssn = n;
		dob = d;
	}

	@Override
	public int compareTo(Person arg0) {
		
		Comparator<String> c = (s1, s2) -> s1.compareToIgnoreCase(s2);
		Comparator<Person> cL = (p1, p2) -> c.compare(p1.lastName, p2.lastName);
		Comparator<Person> cF = (p1, p2) -> c.compare(p1.firstName, p2.firstName);
		return cL.thenComparing(cF).compare(this, arg0);
		
	}

	public static Comparator<Person> bySSN() {
		return Comparator.comparingLong(p -> p.ssn);
	}

	public static Comparator<Person> byDOB() {
		Comparator<LocalDate> cD = Comparator.naturalOrder();
		return (p1, p2) -> cD.compare(p1.dob, p2.dob);
	}

	public String toSSN() {
		String s = "000000000" + ssn;
		s = s.substring(s.length()-9);
		return s.substring(0, 3) + "-" + s.substring(3, 5) 
		+ "-" + s.substring(5); 
	}
}
