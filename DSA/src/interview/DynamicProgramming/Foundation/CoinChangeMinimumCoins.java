package interview.DynamicProgramming.Foundation;

public class CoinChangeMinimumCoins {
	private static int getMinNoOfCoins(int[] coins, int length, int sum) {
		int dp[][] = new int[coins.length + 1][sum +1];	
		// Set the first Row as MAX VALUE
		for(int j = 0; j < dp[0].length ; j++)
			dp[0][j] = Integer.MAX_VALUE -1 ; 
		for(int j = 1 ; j < dp[0].length ; j++ ){
			if(j % coins[0] == 0)
				dp[1][j] = j / coins[0];
			else
				dp[1][j] = Integer.MAX_VALUE -1;
				
		}
		
		for(int  i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(coins[i-1] <= j){
					//min of including the current coin value or excluding the current coin value
					dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1 , dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];	
				}
			}
		}
		return dp[length][sum];
	}
	
	public static void main(String[] args) {
		int coin[] = {2,3,5,6};
		int length = coin.length;
		int sum = 7;
		int minNo = getMinNoOfCoins(coin , length , sum);
		System.out.println("The Minimum No of Coins required : " + minNo);
	}
}
