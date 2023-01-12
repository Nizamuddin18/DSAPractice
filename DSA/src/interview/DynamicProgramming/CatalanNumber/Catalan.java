package interview.DynamicProgramming.CatalanNumber;

import java.math.BigInteger;

public class Catalan {

	public static void main(String[] args) {
		/*int n = 5;
		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2 ; i < dp.length ; i++){
			for(int k = 0 ; k < i ; k++){
				dp[i]+= dp[k] * dp[i-k-1];
			}
		}
		System.out.println(n + "th Catalan Number : " + dp[n]);
		*/
		int n = 5;
		BigInteger total = new BigInteger("5");
		BigInteger[] series = new BigInteger[total.intValue()];
		series[0] = BigInteger.ONE;
		series[1] = BigInteger.ONE;
		for(int i = 2 ; i < series.length ; i++){
			series[i] = BigInteger.ZERO;
		}
	    for(int i = 0 ; i < series.length ; i++){
		    System.out.println(series[i]);

	    }

	}

}
