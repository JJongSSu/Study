package chap6_2;

public class GugudanExample {

	public static void main(String[] args) {
		
		Gugudan gugudan = new Gugudan();
//		gugudan.printOne(2);
//		gugudan.printAll();
//		gugudan.printFrom(7);
		
		SubGugudan subgugudan = new SubGugudan();
		subgugudan.printFrom(5);
		subgugudan.printFrom(5,"down");

	}

}
