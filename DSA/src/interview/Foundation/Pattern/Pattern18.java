package interview.Foundation.Pattern;

import java.util.Scanner;
/*

*	*	*	*	*	*	*	
	*				*	
		*		*	
			*	
		*	*	*	
	*	*	*	*	*	
*	*	*	*	*	*	*	


*/

public class Pattern18 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = 7;//sc.nextInt();
	    for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i < n/2){
					if (i == j || i + j == n - 1 || i == 0) {
						System.out.print("*\t");
					} else {
						System.out.print("\t");
					}
				}else{
					if(i >= j && i+j >= n-1){
						System.out.print("*\t");
					}else {
						System.out.print("\t");
					}
				}	
			}
			System.out.println();
		}
	 }	
}
