package interview.Foundation.Pattern;
/*
 
*	
*	*
* 	*	*
*	*	*	*
*	*	*	*	*


*/
public class Pattern1 {
	private static void printPatternUsingStarSpace(int n) {
		int nst = 1;
		for(int i = 0 ; i < n ; i++){
			for(int st = 1 ; st <= nst ; st++){
				System.out.print("*  ");
			}
			nst++;
			System.out.println();
		}	
	}

	private static void printPatternUsingLPP(int n) {
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i >= j){
					System.out.print("*  ");
				}else{
					System.out.print("  ");
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
