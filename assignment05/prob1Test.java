package assignment05;

public class prob1Test {
	public static void main(String[] args) {
		Parent p = new Parent();
		p.setpName("Tom");
		p.print();
		p = new Child(); 
		p.setpName("Dick"); 
		((Child)p).setcName("Harry"); 
		p.print(); 
	}
}
