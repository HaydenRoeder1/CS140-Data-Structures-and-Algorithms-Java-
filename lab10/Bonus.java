package lab10;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.*;
public class Bonus {
	private static List<Department> departments = new ArrayList<>();
	
	static{
		Employee john = new Employee("John Doe", 30);
		Employee jane = new Employee("Jane Deer", 25);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White", 22);
		
		Employee jared = new Employee("Jared Miller", 60);
		Employee jeff = new Employee("Jeff Jackson", 27);
		Employee gerald = new Employee("Gerald House", 15);
		Employee mary = new Employee("Mary Lou", 23);
		
		Department hr = new Department("Human Resources");
		hr.addEmployee(jane);
		hr.addEmployee(jack);
		hr.addEmployee(snow);
		Department accounting = new Department("Accounting");
		accounting.addEmployee(john);
		accounting.addEmployee(jared);
		accounting.addEmployee(jeff);
		accounting.addEmployee(gerald);
		accounting.addEmployee(mary);
		
		departments.add(hr);
		departments.add(accounting);
	}
	public static void printYoungestEmployee(){
		Employee lowest = departments.stream().flatMap(e -> e.getEmployees().stream())
		.reduce(new Employee("a", 2000), (a,b) -> {if(a.getAge() < b.getAge()) return a; return b;});
		System.out.println("Youngest Employee: " + lowest.toString());
	}
	public static void main(String[] args) {
		printYoungestEmployee();
	}
}
