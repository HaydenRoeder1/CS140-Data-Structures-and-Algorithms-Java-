package assignment06;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class TestStudent {

	@Test
	void test() {
		ArrayList<Student> listS = new ArrayList<Student>();
		Student p1 = new Student("Steve","Jones",22345,LocalDate.parse("1984-05-02"), 95);
		Student p2 = new Student("Jacob","Smith",12345,LocalDate.parse("1995-06-08"), 83);
		Student p3 = new Student("Chad","Gleason",42345,LocalDate.parse("1988-07-03"), 100);
		Student p4 = new Student("James","Rizzo",32345,LocalDate.parse("1992-04-05"), 77);
		
		listS.add(p1);
		listS.add(p2);
		listS.add(p3);
		listS.add(p4);
		
		Collections.sort(listS);
		assertEquals(p3, listS.get(0));
		assertEquals(p1, listS.get(1));
		assertEquals(p4, listS.get(2));
		assertEquals(p2, listS.get(3));
		listS.sort(Student.byDOB());
		assertEquals(p1, listS.get(0));
		assertEquals(p3, listS.get(1));
		assertEquals(p4, listS.get(2));
		assertEquals(p2, listS.get(3));
		listS.sort(Student.bySSN());
		assertEquals(p2, listS.get(0));
		assertEquals(p1, listS.get(1));
		assertEquals(p4, listS.get(2));
		assertEquals(p3, listS.get(3));
		listS.sort(Student.byGPA());
		assertEquals(p4, listS.get(0));
		assertEquals(p2, listS.get(1));
		assertEquals(p1, listS.get(2));
		assertEquals(p3, listS.get(3));
		
	}

}
