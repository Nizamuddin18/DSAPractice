package interview.DynamicProgramming.KnapSack;

public class CountSubsetSum {
	public int getCountOfSubset(int wt[], int length, int sum) {
		int dp[][] = new int[length + 1][sum + 1];
		// Initialisation
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = 1;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - wt[i - 1]];
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[length][sum];
	}

}
