package interview.DynamicProgramming.Foundation;


public class CoinChangePermutations {
	public static int coinChangePermutationsRecursion(int coins[], int sum) {
		if (sum == 0) {
			return 1;
		}

		int count = 0;
		for (int coin : coins) {
			if (sum - coin >= 0)
				count += coinChangePermutationsRecursion(coins, sum - coin);
		}
		return count;
	}

	public static int coinChangePermutationsMemoization(int coins[] , int sum , int dp[]){
		if(sum == 0){
			return dp[sum] = 1;
		}
		if(dp[sum] != 0){
			return dp[sum];
		}
		
		int count = 0;
		for(int coin : coins){
			if(sum - coin >= 0)
				count += coinChangePermutationsMemoization(coins , sum - coin , dp);
		}
		return dp[sum] = count;
	}
	
	public static int coinChangePermutationsTabulation2(int coins[] , int sum , int dp[]){
		for(int target = 0 ; target <= sum ; target++){
			if(target == 0){
				dp[target] = 1;
				continue;
			}
			int count = 0;
			for(int coin : coins){
				if(target - coin >= 0)
					count += dp[target - coin];
			}
			dp[target] = count;
		}
		return dp[sum];
	}
	
	public static int coinChangePermutationsTabulation(int coins[] , int sum){
		int dp[] = new int[sum+1];
		dp[0] = 1;
		for(int amt = 1 ; amt <= sum ; amt++){
			for(int j = 0 ; j < coins.length ; j++){
				if(coins[j] <= amt){
					dp[amt] = dp[amt] + dp[amt-coins[j]];
				}
			}
		}
		return dp[sum];
	}
	
	public static void main(String[] args) {
		int coins[] = {2,3,5,6};
		int sum = 7;
		int dp[] = new int[sum+1];

		int noofcoinspermutation1 = coinChangePermutationsRecursion(coins , sum);
		int noofcoinspermutation2 = coinChangePermutationsMemoization(coins , sum , dp);
		int noofcoinspermutation3 = coinChangePermutationsTabulation(coins , sum);
		int noofcoinspermutation4 = coinChangePermutationsTabulation2(coins , sum , dp);

		System.out.println("Coin Change Permutation (Recursion)  : " + noofcoinspermutation1);
		System.out.println("Coin Change Permutation (Memoization): " + noofcoinspermutation2);
		System.out.println("Coin Change Permutation (Tabulation) : " + noofcoinspermutation3);
		System.out.println("Coin Change Permutation (Tabulation2): " + noofcoinspermutation4);
	}
}
