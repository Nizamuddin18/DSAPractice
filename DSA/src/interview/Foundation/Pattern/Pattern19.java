package interview.Foundation.Pattern;

public class Pattern19 {
	private static void printPatternUsingStarSpace(int n) {
		
	}
	private static void printPatternUsingLPP(int n) {
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(j == 0 || j == n-1 || (i >= n/2 && i + j == n-1) || (i >= n/2 && i == j)){
					System.out.print("*\t");
				}else{
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 7;// sc.nextInt();
		printPatternUsingLPP(n);
		//printPatternUsingStarSpace(n);
	}
	
}
