package interview.Foundation.Recursion;

public class PrintDecreasingIncreasing {
	private static void printDecreasingIncreasing(int n) {
		if(n == 0){
			System.out.println();
			return;
		}
		System.out.print(n + " ");
		printDecreasingIncreasing(n-1);
		System.out.print(n + " ");
	}
	public static void main(String[] args) {
		int n = 5;
		printDecreasingIncreasing(n);
	}
}
