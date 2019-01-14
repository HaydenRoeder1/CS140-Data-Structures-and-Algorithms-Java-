package assignment06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
class TestPerson {
	ArrayList<Person> listP = new ArrayList<Person>();
	@Test
	void test() {

		Person p1 = new Person("Steve","Jones",22345,LocalDate.parse("1984-05-02"));
		Person p2 = new Person("Jacob","Smith",12345,LocalDate.parse("1995-06-08"));
		Person p3 = new Person("Chad","Gleason",42345,LocalDate.parse("1988-07-03"));
		Person p4 = new Person("James","Rizzo",32345,LocalDate.parse("1992-04-05"));
		listP.add(p1);
		listP.add(p2);
		listP.add(p3);
		listP.add(p4);

		Collections.sort(listP);
		assertEquals(p3, listP.get(0));
		assertEquals(p1, listP.get(1));
		assertEquals(p4, listP.get(2));
		assertEquals(p2, listP.get(3));
		listP.sort(Person.byDOB());
		assertEquals(p1, listP.get(0));
		assertEquals(p3, listP.get(1));
		assertEquals(p4, listP.get(2));
		assertEquals(p2, listP.get(3));
		listP.sort(Person.bySSN());
		assertEquals(p2, listP.get(0));
		assertEquals(p1, listP.get(1));
		assertEquals(p4, listP.get(2));
		assertEquals(p3, listP.get(3));
	}

}
