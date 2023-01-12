package interview.Foundation.Recursion;

public class PrintZigZag {
	private static void printZigZag(int n) {
		if(n == 0) return;
		System.out.println(n);
		printZigZag(n-1);
		System.out.println(n);
		printZigZag(n-1);
		System.out.println(n);
		
	}
	public static void main(String[] args) {
		int n = 3;
		printZigZag(n);
	
	}
}
