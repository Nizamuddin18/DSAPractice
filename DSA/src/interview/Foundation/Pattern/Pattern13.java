package interview.Foundation.Pattern;
/*

1	
1	1	
1	2	1	
1	3	3	1	
1	4	6	4	1	


*/

public class Pattern13 {
	private static void printPatternUsingStarSpace(int n) {
		
	}

	private static void printPatternUsingLPP(int n) {
		for(int i = 0 ; i < n ; i++){
			int icj = 1;
			for(int j = 0 ; j < n ; j++){
				if(i >= j){
					System.out.print(icj + "\t");
					int icjplus1 = icj * (i-j) / (j+1);
					icj = icjplus1;
				}else{
					System.out.print("\t");
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
