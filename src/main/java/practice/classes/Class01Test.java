package practice.classes;

public class Class01Test {

	public static void main(String[] args) {

		
		Class01 c1 = new Class01();
		c1.print();
		
		new Class01().print();
		
		
		Class01 c2 = new Class01("2번에 넘기는 값");
		c2.print();
				
		new Class01("2번에 넘기는 값").print();
		
		

		
	}

}
