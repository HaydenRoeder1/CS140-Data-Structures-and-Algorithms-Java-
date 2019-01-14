package assignment05;

public class Sausage extends PizzaTopping {
	public Sausage(Pizza p) {
		super(p);
	}
	@Override
	public double getCost() {
		return .35 + getOn().getCost();
	}
}
