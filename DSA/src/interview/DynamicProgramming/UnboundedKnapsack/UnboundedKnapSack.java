package interview.DynamicProgramming.UnboundedKnapsack;

public class UnboundedKnapSack {
	public int getUnboundedKp(int wt[], int val[] , int length , int wc){
		int dp[][] = new int[length + 1][wc + 1];
		for(int i = 0; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length; j++){
				if( i == 0 || j == 0) {
					dp[i][j] = 0;
					continue;
				}
				if(wt[i-1] <= j)
					dp[i][j] = Math.max(val[i-1] + dp[i][j- wt[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[length][wc];		
	}
}
