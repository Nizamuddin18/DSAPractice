package interview.Foundation.Pattern;

/*
3 * 1 = 3
3 * 2 = 6
3 * 3 = 9
3 * 4 = 12
3 * 5 = 15
3 * 6 = 18
3 * 7 = 21
3 * 8 = 24
3 * 9 = 27
3 * 10 = 30

*/




public class Pattern14 {
	private static void printPatternUsingStarSpace(int n) {
		
	}

	private static void printPatternUsingLPP(int n) {
		for(int i = 1 ; i <= 10 ; i++){
			System.out.println(n + " * " + i + " = " + n * i);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		printPatternUsingLPP(n);
		printPatternUsingStarSpace(n);	
	}

}
