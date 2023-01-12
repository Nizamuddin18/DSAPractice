package interview.DynamicProgramming.Foundation;

public class CountBinaryStrings {

	public static void main(String[] args) {
		int n = 4; // binary String of length n
		int inc = 1;
		int exc = 1;
		for(int i = 2 ; i <= n ; i++){
			int ninc = exc;
			int nexc = inc + exc;
			
			inc = ninc;
			exc = nexc;
		}
		System.out.println("Binary String with no two O's of length " + n + " is :  " + (inc + exc));
	}
}
