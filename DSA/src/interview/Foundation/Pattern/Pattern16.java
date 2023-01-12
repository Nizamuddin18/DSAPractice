package interview.Foundation.Pattern;

public class Pattern16 {
	private static void printPatternUsingStarSpace(int n) {
		int nsp = 2*n-3;
		int nst = 1;
		int count,count2;
		for(int i = 0 ; i < n ; i++){
			count = 1;
			count2 = count;
			for(int st = 0 ; st < nst ; st++){
				System.out.print(count2 + "\t");
				count2++;
			}
			for(int sp = 0 ; sp < nsp ; sp++){
				System.out.print("\t");
			}
			if(i == n-1){
				count2 = count2 - 2;
				for(int st = 0 ; st < nst-1 ; st++){	
					System.out.print(count2 + "\t");
					count2--;
				}	
			}else{
				count2--;
				for(int st = 0 ; st < nst ; st++){
					System.out.print(count2 + "\t");
					count2--;
				}
			}
			
			nsp = nsp - 2;
			nst++;
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = 7;
		printPatternUsingStarSpace(n);
	}

}
