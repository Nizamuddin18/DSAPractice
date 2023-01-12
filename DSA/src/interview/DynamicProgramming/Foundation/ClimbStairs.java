package interview.DynamicProgramming.Foundation;

public class ClimbStairs {
	public static int climbStiarsRecursion(int n){
		if(n == 0)
			return 1;
		int count = 0;
		for(int jump = 1 ; jump <= 3 && n - jump >= 0; jump++){
			count += climbStiarsRecursion(n-jump);
		}
		return count;
	}
	
	public static int climbStairsMemoization(int n, int cache[]) {
		if (n == 0)
			return cache[n] = 1;
		if (cache[n] != 0)
			return cache[n];
		int count = 0;
		for (int jump = 1; jump <= 3; jump++) {
			if (n - jump >= 0)
				count += climbStairsMemoization(n - jump, cache);
		}
		return cache[n] = count;
	}

	public static int climbStairsTabulation2(int n) {
		int dp[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i == 0) {
				dp[i] = 1;
				continue;
			}

			int count = 0;
			for (int jump = 1; jump <= 3; jump++) {
				if (i - jump >= 0)
					count += dp[i - jump];
			}
			dp[i] = count;
		}
		return dp[n];
	}

	public static int climbStairsTabulation(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 1; // for moving from basement to basement
		for (int i = 1; i < dp.length; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 3;
		int cache[] = new int[n + 1];
		int totalCountMemo = climbStairsMemoization(n, cache);
		int totalCountTab = climbStairsTabulation2(n);
		int totalCountRec = climbStiarsRecursion(n);
		System.out.println("Total No of Ways through Recursion   : " + totalCountRec);
		System.out.println("Total No of Ways through Memoization : " + totalCountMemo);
		System.out.println("Total No of Ways through Tabulation  : " + totalCountTab);
	}
	
}

	
