package interview.DynamicProgramming.Foundation;

public class CoinChangeCombinations {
	public static int coinChangeCombinationRecursion(int coins[] , int target){
		return 0;
	}
	
	public static int coinChangeCombinationMemoization(int coins[] , int target , int dp[]){
		return 0;
	}
	
	public static int coinChangeCombinationTabulation1(int coins[] , int target){
		int dp[] = new int[target+1];
		dp[0] = 1;
		for(int i = 0 ; i < coins.length; i++){
			for(int j = coins[i] ; j < dp.length ; j++){
				if(j - coins[i] >= 0){
					dp[j] = dp[j] + dp[j-coins[i]];
				}
			}
		}
		return dp[target];
	}
	
	public static int coinChangeCombinationTabulation2(int coins[] , int target , int dp[]){
		return 0;
	}
	
	public static void main(String[] args) {
		int coins[] = {2,3,5,6};
		int sum = 7;
		int dp[] = new int[sum+1];
		
		int noofcoinscombibnation1 = coinChangeCombinationRecursion(coins , sum);
		int noofcoinscombibnation2 = coinChangeCombinationMemoization(coins , sum , dp);
		int noofcoinscombibnation3 = coinChangeCombinationTabulation1(coins , sum);
		int noofcoinscombibnation4 = coinChangeCombinationTabulation2(coins , sum , dp);
		//System.out.println("Coin Change Combination (Recursion)   : " + noofcoinscombibnation1);
		//System.out.println("Coin Change Combination (Memoization) : " + noofcoinscombibnation2);
		System.out.println("Coin Change Combination (Tabulation1) : " + noofcoinscombibnation3);
		//System.out.println("Coin Change Combination (Tabulation2) : " + noofcoinscombibnation4);
	}
}
