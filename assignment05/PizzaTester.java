package assignment05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PizzaTester {

	@Test
	void test1() {
		Pizza order = new MediumCheesePizza();
		order = new Mushroom(order);
		order = new Pepperoni(order);
		order = new Sausage(order);
		order = new Peppers(order);
		
		assertEquals(10.95, order.getCost(), 0.000001);
	}
	@Test
	void test2() {
		Pizza order = new SmallCheesePizza();
		order = new Mushroom(order);
		order = new Pepperoni(order);
		order = new Sausage(order);
		order = new Peppers(order);
		
		assertEquals(7.95, order.getCost(), 0.000001);
	}

}
