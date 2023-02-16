package interview.DynamicProgramming.Foundation;

import java.util.Scanner;

public class Solutions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int temp = n;
		int rem = 0;
		int count = 0;
		int newVal = 0;
		while (temp > 0) {
			count++; 
			int lastVal = temp % 10;
			rem = newVal;
			newVal = shiftToPosition(count, lastVal);

			newVal = newVal + rem;
			temp = temp / 10;
		}
		System.out.println(newVal);
	}

	private static int shiftToPosition(int count, int lastVal) {
		int tenpowk = 1;
		for (int i = 1; i < lastVal; i++) {
			tenpowk = tenpowk * 10;
		}
		int retVal = count * tenpowk;
		return retVal;
	}
}
