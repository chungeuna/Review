package AOP_Basic_01;

public class Program {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int result = calc.add(1000, 1000);
		System.out.println(result);
		
		result = calc.mul(1000, 1000);
		System.out.println(result);
		
	}
}
