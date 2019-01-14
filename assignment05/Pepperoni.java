package assignment05;

public class Pepperoni extends PizzaTopping {
	public Pepperoni(Pizza p) {
		super(p);
	}
	@Override
	public double getCost() {
		return .15 + getOn().getCost();
	}
}
