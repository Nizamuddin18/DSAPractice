package interview.Foundation.Pattern;

public class Pattern15 {
	private static void printPatternUsingStarSpace(int n) {
		int nst = 1;
		int nsp = n/2;
		int count = 0;
		for(int i = 0 ; i < n ; i++){
			if(i <= n/2){
				count = i+1;
			}
			for(int sp = 0 ; sp < nsp ; sp++){
				System.out.print("\t");
			}
			for(int st = 0 ; st < nst ; st++){
				System.out.print(count + "\t");
				if(st < nst/2)
					count++;
				else
					count--;
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
	public static void main(String[] args) {
		int n = 5;
		printPatternUsingStarSpace(n);

	}

}
