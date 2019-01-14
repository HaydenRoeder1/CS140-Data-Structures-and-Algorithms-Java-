package assignment05;

public class Peppers extends PizzaTopping {
	public Peppers(Pizza p) {
		super(p);
	}
	@Override
	public double getCost() {
		return .20 + getOn().getCost();
	}
}
