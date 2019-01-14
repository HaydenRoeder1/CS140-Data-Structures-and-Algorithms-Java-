package assignment06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
class Person1Test {
	ArrayList<Person1> listP = new ArrayList<Person1>();
	@Test
	void test() {

		Person1 p1 = new Person1("Steve","Jones",22345,LocalDate.parse("1984-05-02"));
		Person1 p2 = new Person1("Jacob","Smith",12345,LocalDate.parse("1995-06-08"));
		Person1 p3 = new Person1("Chad","Gleason",42345,LocalDate.parse("1988-07-03"));
		Person1 p4 = new Person1("James","Rizzo",32345,LocalDate.parse("1992-04-05"));
		listP.add(p1);
		listP.add(p2);
		listP.add(p3);
		listP.add(p4);

		Collections.sort(listP);
		assertEquals(p3, listP.get(0));
		assertEquals(p1, listP.get(1));
		assertEquals(p4, listP.get(2));
		assertEquals(p2, listP.get(3));
		listP.sort(Person1.byDOB());
		assertEquals(p1, listP.get(0));
		assertEquals(p3, listP.get(1));
		assertEquals(p4, listP.get(2));
		assertEquals(p2, listP.get(3));
		listP.sort(Person1.bySSN());
		assertEquals(p2, listP.get(0));
		assertEquals(p1, listP.get(1));
		assertEquals(p4, listP.get(2));
		assertEquals(p3, listP.get(3));
	}

}
