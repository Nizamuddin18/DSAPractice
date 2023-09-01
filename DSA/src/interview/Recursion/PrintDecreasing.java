package interview.Recursion;

public class PrintDecreasing {
	private static void printDecreasing(int n) {
		if(n == 0)
			return;
		System.out.println(n);
		printDecreasing(n-1);
	}
	public static void main(String[] args) {
		int n = 5;
		printDecreasing(n);
	}
}
