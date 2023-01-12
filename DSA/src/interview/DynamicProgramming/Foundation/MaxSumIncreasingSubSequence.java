package interview.DynamicProgramming.Foundation;

public class MaxSumIncreasingSubSequence {
	public static int getMaxSumIncreasingSubsequence(int arr[]){
		int dp[] = new int[arr.length];
		int oMax = Integer.MIN_VALUE;
		for(int i = 0 ; i < dp.length ; i++){
			Integer max = null;
			for(int j = 0 ; j < i ; j++){
				if(dp[j] < dp[i]){
					if(max == null)
						max = dp[j];
					else if(dp[j] > max)
						max = dp[j];
				}
			}
			if(max == null)
				dp[i] = arr[i];
			else
				dp[i] = max + arr[i];
			
			if(dp[i] > oMax)
				oMax = dp[i];
		}
		return oMax;
	}
	
	public static void main(String[] args) {
		int arr[] = {10,22,9,33,21,50,41,60,80,3};	
		int sum = getMaxSumIncreasingSubsequence(arr);
		System.out.println("Maximum Sum Increasing Subsequence : " + sum);
	}
}
