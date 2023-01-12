package interview.Foundation.Pattern;

import java.util.Scanner;

/*

		*	
	*		*	
*				*	
	*		*	
		*	
		
		
*/
public class Pattern10 {
	private static void printPatternUsingStarSpace(int n) {
	}

	private static void printPatternUsingLPP(int n) {
		int row = n;
		n = n - 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if (i + j == n / 2 || j - i == n / 2 || i - j == n / 2 || i + j == (3 * n) / 2) {
					System.out.print("*	");
				} else {
					System.out.print("	");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = 5;
		printPatternUsingLPP(n);
		printPatternUsingStarSpace(n);		
	}
}
