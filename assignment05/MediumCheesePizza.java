package assignment05;

public class MediumCheesePizza implements Pizza {

	@Override
	public int compareTo(Pizza p) {
		return 1;
	}

	@Override
	public String getDescription() {
		return "Medium cheese pizza";
	}
	@Override
	public double getCost() {
		return 10.0;
	}

}
