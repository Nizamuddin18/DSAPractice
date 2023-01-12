package interview.Foundation.Pattern;

public class Pattern17 {

	public static void main(String[] args) {
		int n = 5;
		int nsp = n/2;
		int nst = 1;
		for(int i = 0 ; i < n ; i++){
			if(i != n/2){
				for(int sp = 0 ; sp < nsp ; sp++){
					System.out.print("\t");
				}
			}else{
				for(int sp = 0 ; sp < nsp ; sp++){
					System.out.print("*\t");
				}
			}
			
			for(int st = 0 ; st < nst; st++){
				System.out.print("*\t");
			}
			if(i < n/2)
				nst++;
			else
				nst--;
			System.out.println();
		}
	}
}
