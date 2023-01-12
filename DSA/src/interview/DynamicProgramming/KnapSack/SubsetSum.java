package interview.DynamicProgramming.KnapSack;

public class SubsetSum {
	public static boolean getSubSetSumRecursion(int[] arr, int sum, int n) {
		if (sum == 0)
			return true;
		if(sum != 0 && n == 0)
			return false;
		if (arr[n - 1] <= sum) {
			return (getSubSetSumRecursion(arr, sum - arr[n - 1], n - 1) || 
					getSubSetSumRecursion(arr, sum, n - 1));
		} else {
			return getSubSetSumRecursion(arr, sum, n - 1);
		}
	}
		
	public static boolean getsubsetSumMemoization(int arr[], int sum, int n , boolean dp[][]){
		if(sum == 0){	
			return dp[n][sum] = true;
		}
		if(sum!=0 && n==0){
			return dp[n][sum] = false;
		}
		
		if(arr[n-1] <= sum)
			dp[n][sum] = (getsubsetSumMemoization(arr, sum-arr[n-1] , n-1 , dp) ||
					getsubsetSumMemoization(arr, sum , n-1 , dp));
		else
			dp[n][sum] = getsubsetSumMemoization(arr, n-1, sum , dp);
		return dp[n][sum];
	}
	
	public static boolean getSubSet(int arr[] , int length , int sum , boolean t[][]){
		for(int i = 0 ; i<=length ; i++)
			t[i][0] = true;
		for(int i = 1; i<= length ; i++){
			for(int j = 1 ; j<=sum ; j++){
				if(arr[i-1] <= j)
					t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
				else
					t[i][j] = t[i-1][j];
			}
		}
		return t[length][sum];
	}
	
	public static void main(String [] args){
		int arr[] = {1,2,3,4,5};
		int n = arr.length;
		int sum = 15;
		boolean dp[][] = new boolean[n+1][sum+1];
		boolean flag1 = getSubSetSumRecursion(arr , sum , n);
		boolean flag2 = getsubsetSumMemoization(arr , sum , n , dp);
		boolean flag3 = getSubSet(arr , n , sum , dp);
		System.out.println("Subset Sum using Recursion  : " 	+ flag1);
		System.out.println("Subset Sum using Memoization: " 	+ flag2);
		System.out.println("Subset Sum using Tabulation : " 	+ flag3);
	}
}
