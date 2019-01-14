package assignment05;

public class Mushroom extends PizzaTopping {
	public Mushroom(Pizza p) {
		super(p);
	}
	@Override
	public double getCost() {
		return .25 + getOn().getCost();
	}
}
