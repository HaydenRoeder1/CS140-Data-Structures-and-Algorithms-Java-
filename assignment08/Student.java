package assignment08;
public class Student {
	private String name;
	private int numCreditsCompleted;
	private String major;
	
	public String getMajor() {return major;}
	public void setMajor(String s) {major = s;}
	public String getName() {return name;}
	public int getNumCreditsCompleted() {return numCreditsCompleted;}
	
	public Student(String n, int numCreds) {
		name = n;
		numCreditsCompleted = numCreds;
		major = "Undeclared";
	}
	public String toString() {
		return name + "(" + major + " : " + numCreditsCompleted + ")";
	}
}
