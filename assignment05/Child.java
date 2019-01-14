package assignment05;

public class Child extends Parent {
	private String cName;
	public void setcName(String s) {cName = s;}
	public void print() {
		System.out.println(cName);
		super.print();
	}
}
