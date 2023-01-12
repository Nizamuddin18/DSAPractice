package interview.DynamicProgramming.UnboundedKnapsack;

public class MinNoOfCoin {
	public int getMinimumNoPossible(int coin[], int length, int sum) {
		int dp[][] = new int[length + 1][sum + 1];
		int max = Integer.MAX_VALUE;
		for (int i = 1; i < dp[0].length; i++)
			dp[0][i] = max - 1;
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coin[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin[i - 1]] + 1);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[length][sum];
	}
}
