package assignment06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class Student1Test {

	@Test
	void testAlphaSort() {
		ArrayList<Student1> listS = new ArrayList<Student1>();
		Student1 p1 = new Student1("Steve","Jones",22345,LocalDate.parse("1984-05-02"), 95);
		Student1 p2 = new Student1("Jacob","Smith",12345,LocalDate.parse("1995-06-08"), 83);
		Student1 p3 = new Student1("Chad","Gleason",42345,LocalDate.parse("1988-07-03"), 100);
		Student1 p4 = new Student1("James","Rizzo",32345,LocalDate.parse("1992-04-05"), 77);
		
		listS.add(p1);
		listS.add(p2);
		listS.add(p3);
		listS.add(p4);
	
		Collections.sort(listS);
		assertEquals(p3, listS.get(0));
		assertEquals(p1, listS.get(1));
		assertEquals(p4, listS.get(2));
		assertEquals(p2, listS.get(3));
	}
	@Test
	void testDOBSort() {
		ArrayList<Student1> listS = new ArrayList<Student1>();
		Student1 p1 = new Student1("Steve","Jones",22345,LocalDate.parse("1984-05-02"), 95);
		Student1 p2 = new Student1("Jacob","Smith",12345,LocalDate.parse("1995-06-08"), 83);
		Student1 p3 = new Student1("Chad","Gleason",42345,LocalDate.parse("1988-07-03"), 100);
		Student1 p4 = new Student1("James","Rizzo",32345,LocalDate.parse("1992-04-05"), 77);
		
		listS.add(p1);
		listS.add(p2);
		listS.add(p3);
		listS.add(p4);
		listS.sort(Student1.byDOB());
		assertEquals(p1, listS.get(0));
		assertEquals(p3, listS.get(1));
		assertEquals(p4, listS.get(2));
		assertEquals(p2, listS.get(3));
	}
	@Test 
	void testSSNSort(){
		ArrayList<Student1> listS = new ArrayList<Student1>();
		Student1 p1 = new Student1("Steve","Jones",22345,LocalDate.parse("1984-05-02"), 95);
		Student1 p2 = new Student1("Jacob","Smith",12345,LocalDate.parse("1995-06-08"), 83);
		Student1 p3 = new Student1("Chad","Gleason",42345,LocalDate.parse("1988-07-03"), 100);
		Student1 p4 = new Student1("James","Rizzo",32345,LocalDate.parse("1992-04-05"), 77);
		
		listS.add(p1);
		listS.add(p2);
		listS.add(p3);
		listS.add(p4);
		listS.sort(Student1.bySSN());
		assertEquals(p2, listS.get(0));
		assertEquals(p1, listS.get(1));
		assertEquals(p4, listS.get(2));
		assertEquals(p3, listS.get(3));
	}
	@Test
	void testGPASort() {
		ArrayList<Student1> listS = new ArrayList<Student1>();
		Student1 p1 = new Student1("Steve","Jones",22345,LocalDate.parse("1984-05-02"), 95);
		Student1 p2 = new Student1("Jacob","Smith",12345,LocalDate.parse("1995-06-08"), 83);
		Student1 p3 = new Student1("Chad","Gleason",42345,LocalDate.parse("1988-07-03"), 100);
		Student1 p4 = new Student1("James","Rizzo",32345,LocalDate.parse("1992-04-05"), 77);
		
		listS.add(p1);
		listS.add(p2);
		listS.add(p3);
		listS.add(p4);
		listS.sort(Student1.byGPA());
		assertEquals(p4, listS.get(0));
		assertEquals(p2, listS.get(1));
		assertEquals(p1, listS.get(2));
		assertEquals(p3, listS.get(3));
	}	

}