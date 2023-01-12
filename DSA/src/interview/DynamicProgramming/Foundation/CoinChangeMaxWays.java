package interview.DynamicProgramming.Foundation;

public class CoinChangeMaxWays {
	private static int getMaxNoOfWays(int[] coin, int sum, int length) {
		int dp[][] = new int[length + 1][sum +1];	
		for(int  i = 0 ; i< dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				if(j == 0)
					dp[i][j] = 1; 	
			}
		}
		 
		for(int  i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(coin[i-1] <= j){
					dp[i][j] = dp[i-1][j] +
							  dp[i][j-coin[i-1]];
				}else{
					dp[i][j] = dp[i-1][j];	
				}
			}
		}
		return dp[length][sum];
	}
	
	public static void main(String[] args) {
		int coin[] = {2,3,5,6};
		int sum = 7;
		int length = coin.length;
		int maxWays = getMaxNoOfWays( coin , sum , length);
		System.out.println("Maximum No of Ways : " + maxWays);

	}


}
