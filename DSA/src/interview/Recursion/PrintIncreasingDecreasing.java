package interview.Recursion;

public class PrintIncreasingDecreasing {
	private static void printIncreasingDecreasing(int n , int i) {
		if(i == n){
			System.out.print(n + " ");
			return;
		}
		System.out.print(i + " ");
		printIncreasingDecreasing(n , i+1);
		System.out.print(i + " ");
	}
	public static void main(String[] args) {
		int n = 5;
		printIncreasingDecreasing(n , 1);
	}

}
