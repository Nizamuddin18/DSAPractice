package interview.Foundation.Pattern;
/*

*				*	
	*		*		
		*			
	*		*		
*				*	


*/



public class Pattern9 {
	private static void printPatternUsingStarSpace(int n) {
		int inspace = n/2 + 1;
		int outspace = 0;
		for(int i = 0 ; i < n ; i++){
			for(int sp = 0 ; sp < outspace ; sp++){
				System.out.print("\t");
			}
			System.out.print("*\t");
			for(int sp = 0 ; sp < inspace ; sp++){
				System.out.print("\t");
			}
			if(i!=n/2)
				System.out.print("*\t");
			if(i < n/2){
				outspace++;
				inspace = inspace - 2;
			}else{
				outspace--;
				inspace = inspace + 2;
			}
			System.out.println();
		}
	}

	private static void printPatternUsingLPP(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || i + j == n - 1) {
					System.out.print("*\t");
				} else {
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
