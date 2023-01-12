package interview.Foundation.Pattern;

public class Pattern20 {
	private static void printPatternUsingLPP(int n) {
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i == n/2 || j == n/2 || (i == 0 && j < n/2) || 
						(j == 0 && i >= n/2) ||  (i == n-1 && j >= n/2) || (j == n-1 && i < n/2)){
					System.out.print("*\t");
				}else{
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 5;// sc.nextInt();
		printPatternUsingLPP(n);
		//printPatternUsingStarSpace(n);
	}
}
