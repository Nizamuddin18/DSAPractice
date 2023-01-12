package interview.DynamicProgramming.KnapSack;

public class SubsetSumWithGivenDifference {
	public int getCountOfSubset(int length , int sum , int arr[]){
		int dp[][] = new int[length+1][sum+1];
		for(int i = 0 ; i < dp.length ; i ++){
			dp[i][0] = 1;
		}
		for(int  i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				int val = arr[i-1];
				if(val <= j){
					dp[i][j] = dp[i-1][j-val] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[length][sum];
	}
}
