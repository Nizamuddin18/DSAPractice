package interview.DynamicProgramming.LCS;

public class LongestIncreasingSubSequence {
	
	public static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ") ;
		System.out.println();
	}
	
	public static int getLongestIncreasingSubsequence(int arr[]){
		int n = arr.length;
		int dpMax = Integer.MIN_VALUE;
		int dp[] = new int[n];
		for(int i = 0 ; i < dp.length ; i++){
			int max = 0;
			for(int j = 0 ; j < i ; j++){
				if(arr[j] < arr[i]){
					if(max < dp[j]){
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			if(dpMax < dp[i]){
				dpMax = dp[i];
			}
		}
		
		//display(dp);
		
		return dpMax;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,5,4,7};	
		int count = getLongestIncreasingSubsequence(arr);
		System.out.println("Longest Increasing Subsequence : " + count);
	}

	
}
