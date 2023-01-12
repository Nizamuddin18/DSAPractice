package interview.DynamicProgramming.KnapSack;

public class MinDifferenceSubset {
	static boolean dp[][];
	public boolean[] getSubset(int[] arr, int n, int sum) {
		/*
		 The method is same as Subset sum method with the only difference being that this returns the last 
		 Row of the matrix for so that we can check that for which indexes minSubset can be obtained.
		 That is if the index value is TRUE then 
		 	we check based on the formula of Range- 2*arr[i]
		 */
        boolean dp[][] = new boolean[n + 1][sum + 1];
        boolean ret_arr[] = new boolean[sum+1];
        for (int i = 0; i <= n; i++) 
            dp[i][0] = true;
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j <dp[0].length; j++){
            	int val = arr[i-1];
            	if(val <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - val];
            	}else{
                    dp[i][j] = dp[i - 1][j];    
            	}
            }
        }
        for(int i=0;i< dp[0].length;i++)
        	ret_arr[i]=dp[n][i];
        
        return ret_arr;
	}
	
	public int getMinDiff(boolean[] ret_arr, int sum, int n, int[] arr){
		int min_val = Integer.MAX_VALUE;
		int range = sum;
		int len = ret_arr.length / 2;
		int val = 0;
		for(int i=1;i <= len; i++){
			if(ret_arr[i])
				val = Math.abs(range-2*i);
				min_val = Math.min(min_val, val);
		}	
		return (min_val);
		
	}
	
	public int getRange(int arr[], int n)
	{
		int sum = 0;
		for(int i=0; i<n;i++)
			sum +=arr[i];
		return sum;
	}
}
