package assignment06;

import java.time.LocalDate;
import java.util.Comparator;

public class Person1 implements Comparable<Person1> {
	private String firstName;
	private String lastName;
	private long ssn;
	private LocalDate dob;

	public Person1(String fstN, String lstN, long n, LocalDate d) {
		firstName = fstN;
		lastName = lstN;
		ssn = n;
		dob = d;
	}
	public String getFName() {return firstName;}
	public String getLName() {return lastName;}
	public long getSSN() {return ssn;}
	public LocalDate getDOB() {return dob;}
	
	@Override
	public int compareTo(Person1 arg0) {
		if(!lastName.equalsIgnoreCase(arg0.getLName())) {
			return lastName.compareToIgnoreCase(arg0.getLName());
		}
		return firstName.compareToIgnoreCase(arg0.getFName());
		
	}

	public static Comparator<Person1> bySSN() {
		return new Comparator<Person1>() {
				@Override
				public int compare(Person1 arg0,Person1 arg1) {
					if(arg0.getSSN() < arg1.getSSN()) {
						return -1;
					}else if(arg0.getSSN() == arg1.getSSN()) {
						return 0;
					}else {
						return 1;
					}
				}
		};
	}

	public static Comparator<Person1> byDOB() {
		return new Comparator<Person1>() {
			@Override
			public int compare(Person1 arg0,Person1 arg1) {
				LocalDate dob1 = arg0.getDOB();
				LocalDate dob2 = arg1.getDOB();
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
		String s = "000000000" + ssn;
		s = s.substring(s.length()-9);
		return s.substring(0, 3) + "-" + s.substring(3, 5) 
		+ "-" + s.substring(5); 
	}
}