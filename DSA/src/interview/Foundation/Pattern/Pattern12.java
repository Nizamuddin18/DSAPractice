package interview.Foundation.Pattern;

/*
0	
1	1	
2	3	5	
8	13	21	34	
55	89	144	233	377	

*/

public class Pattern12 {
	private static void printPatternUsingStarSpace(int n) {
		
	}

	private static void printPatternUsingLPP(int n) {
		int prev = 0;
		int next = 1;
		int temp;
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i >= j){
					System.out.print(prev + "\t");
					temp = prev + next;
					prev = next;
					next = temp;
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
