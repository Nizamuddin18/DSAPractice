package interview.DynamicProgramming.KnapSack;

public class KnapSack01 {
	public int KnapSack01Tabulation1(int wt[], int val[], int length, int wc) {
		int t[][] = new int[length + 1][wc + 1];
		for (int i = 1; i < length + 1; i++) {
			for (int j = 1; j < wc + 1; j++) {
				// if the selected weight is less than the Current Weight of Knapsack(j)
				if (wt[i - 1] <= j){
					// check among them whether to include the weight or not
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
				} else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[length][wc];
	}
	
	public int KnapSack01Tabulation2(int[] wt, int[] val, int Wc, int n , int dp[][]) {
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				if (i == 0 || j == 0){
					dp[i][j] =  0;
					continue;
				}
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i- 1][j - wt[i - 1]], dp[i - 1][j]);
				}else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][Wc];
	}

	public int KnapSack01Recursion(int[] wt, int[] val, int Wc, int n) {
		if (n == 0 || Wc == 0)
			return 0;
		if (wt[n - 1] <= Wc) {
			return Math.max(val[n - 1] + KnapSack01Recursion(wt, val, Wc - wt[n - 1], n - 1),
					KnapSack01Recursion(wt, val, Wc, n - 1));
		} else {
			return KnapSack01Recursion(wt, val, Wc, n - 1);
		}
	}
	
	public int KnapSack01Memoization(int[] wt, int[] val, int Wc, int n , int t[][]) {
		if (n == 0 || Wc == 0)
			return t[n][Wc] = 0;
		
		if (t[n][Wc] != -1)
			return t[n][Wc];
		
		if (wt[n - 1] <= Wc) {
			t[n][Wc] = Math.max(val[n - 1] + KnapSack01Memoization(wt, val, Wc - wt[n - 1], n - 1 , t),
					KnapSack01Memoization(wt, val, Wc, n - 1 , t));
		} else {
			t[n][Wc] = KnapSack01Memoization(wt, val, Wc, n - 1 , t);
		}
		return t[n][Wc];
	}

}
