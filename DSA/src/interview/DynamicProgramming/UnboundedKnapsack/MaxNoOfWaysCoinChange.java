package interview.DynamicProgramming.UnboundedKnapsack;

public class MaxNoOfWaysCoinChange {
	public int getMaxNoOfWays(int[] coin, int sum, int length) {
		int dp[][] = new int[length + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = 1;
					continue;
				}
				if (coin[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[length][sum];
	}
}
