package interview.Foundation.Pattern;
/*
				*	
			*	*	
		*	*	*	
	*	*	*	*	
*	*	*	*	*	


*/
public class Pattern3 {
	private static void printPatternUsingStarSpace(int n) {
		int nst = 1;
		int nsp = n-1;
		for(int i = 0 ; i < n ; i++){
			for(int sp = 0 ; sp < nsp ; sp++){
				System.out.print("\t");
			}
			for(int st = 1 ; st <= nst ; st++){
				System.out.print("*\t");
			}
			nst++;
			nsp--;
			System.out.println();
		}	
	}

	private static void printPatternUsingLPP(int n) {
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i + j >= n-1){
					System.out.print("*\t");
					
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
