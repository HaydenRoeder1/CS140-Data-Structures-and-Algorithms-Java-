package assignment05;

public interface Pizza extends Comparable<Pizza>{
	String getDescription();
	default double getCost() {
		return 0.0;
	}
}
