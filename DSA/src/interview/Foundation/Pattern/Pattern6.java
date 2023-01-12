package interview.Foundation.Pattern;

/*
 

*	*	*		*	*	*	
*	*				*	*	
*						*	
*	*				*	*	
*	*	*		*	*	*	


*/




public class Pattern6 {
	private static void printPatternUsingStarSpace(int n) {
		int nst = n/2 +1;
		int nsp = 1;
		for(int i = 0 ; i < n ; i++){
			for (int st = 0; st < nst; st++) {
				System.out.print("*\t");
			}
			for (int sp = 0; sp < nsp; sp++) {
				System.out.print("\t");
			}
			for (int st = 0; st < nst; st++) {
				System.out.print("*\t");
			}
			if(i < n/2){
				nst--;
				nsp = nsp + 2;
			}else{
				nst++;
				nsp = nsp - 2;
			}
			System.out.println();
		}
	}

	private static void printPatternUsingLPP(int n) {
		
	}
	public static void main(String[] args) {
		int n = 5;
		printPatternUsingLPP(n);
		printPatternUsingStarSpace(n);	
	}
}
