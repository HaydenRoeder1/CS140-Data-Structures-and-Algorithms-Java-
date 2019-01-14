package assignment05;

public abstract class PizzaTopping implements Pizza {
	private Pizza on;
	
	public PizzaTopping(Pizza p) {
		on = p;
	}
	
	public Pizza getOn() {return on;}
	public void setOn(Pizza p) {on = p;}
	
	@Override
	public int compareTo(Pizza p) {
		if(p instanceof PizzaTopping) {
			return getClass().getSimpleName().compareTo(p.getClass().getSimpleName());
		}
		return -1;
	}

	@Override
	public String getDescription() {
		String retStr = getClass().getSimpleName();
		if(on instanceof PizzaTopping) {
			retStr += ", " + on.getDescription();
		}
		else {
			retStr += " on " + on.getDescription();
		}
		return retStr;
	}


}
