package interview.Foundation.Pattern;
/*		
 
 		*	
	*	*	*	
*	*	*	*	*	
	*	*	*	
		*	
		
*/
public class Pattern5 {
	private static void printPatternUsingStarSpace(int n) {
		int nst = 1;
		int nsp = n/2;
		for(int i = 0 ; i < n ; i++){
			for(int sp = 0 ; sp < nsp ; sp++){
				System.out.print("\t");
			}
			for(int st = 0 ; st < nst ; st++){
				System.out.print("*\t");
			}
			if(i < n/2){
				nst = nst + 2;
				nsp--;
			}else{
				nst = nst - 2;
				nsp++;
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
