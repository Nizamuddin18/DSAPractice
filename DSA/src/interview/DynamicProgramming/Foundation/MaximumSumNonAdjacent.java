package interview.DynamicProgramming.Foundation;

import java.util.*;

public class MaximumSumNonAdjacent {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 10, 100, 5, 6 };
		int maxSumTab = maxSumNonAdjacentTabulation(arr);
		int maxSumRec = maxSumNonAdjacentRecursion(arr , arr.length-1 , 0);
		int dp[] = new int[arr.length+1];
		Arrays.fill(dp, -1);
		int maxSumMemo = maxSumNonAdjacentMemoization(arr , arr.length-1 , 0 , dp);
		System.out.println("maxSumNonAdjacentTabulation : " + maxSumTab);
		System.out.println("maxSumNonAdjacentRecursion  : " + maxSumRec);
		System.out.println("maxSumNonAdjacentMemoization  : " + maxSumMemo);
	}

	private static int maxSumNonAdjacentRecursion(int[] arr, int index, int state) {
		if(index == -1) return 0;
		int max = -(int)1e9;
		if(state == 0)
			max = maxSumNonAdjacentRecursion(arr , index-1 , 1) + arr[index];
		max = Math.max(max, maxSumNonAdjacentRecursion(arr , index-1 , 0));
		return max;
	}
	
	private static int maxSumNonAdjacentMemoization(int[] arr, int index, int state , int dp[]) {
		if(index == -1) return dp[index] = 0;
		if(dp[index] != -1) return dp[index];
		int max = -(int)1e9;
		if(state == 0)
			max = maxSumNonAdjacentMemoization(arr , index-1 , 1 , dp) + arr[index];
		max = Math.max(max, maxSumNonAdjacentMemoization(arr , index-1 , 0 , dp));
		return dp[index] = max;
	}

	private static int maxSumNonAdjacentTabulation(int[] arr) {
		int oldinc = arr[0];
		int oldexc = 0;
		for (int i = 1; i < arr.length; i++) {
			int newinc = oldexc + arr[i];
			int newexc = Math.max(oldinc, oldexc);
			oldexc = newexc;
			oldinc = newinc;
		}
		return Math.max(oldexc, oldinc);
	}
}
