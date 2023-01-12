package interview.DynamicProgramming.Foundation;
import java.util.Arrays;

public class ClimbStairsWithMinMoves {

	public static void main(String[] args) {
		int jumps[] = { 3, 3, 0, 2, 2, 3 };
		int minMoves = climbStairsWithMinimumMovesTabulation(jumps);
		System.out.println("Minimum Moves required to Move from 0 to " + jumps.length + " : " + minMoves);
	}

	private static void display(int dp[]) {
		for (int i = 0; i < dp.length; i++)
			System.out.print(dp[i] + " ");
		System.out.println();
	}

	public static int climbStairsWithMinimumMovesTabulation(int[] arr) {
		int n = arr.length;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		for (int i = n; i >= 0; i--) {
			if(i == n){
				dp[i] = 0;
				continue;
			}
			
			if (arr[i] > 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
					if (dp[i + j] != -1)
						min = Math.min(min, dp[i + j]);
				}
				if (min != Integer.MAX_VALUE)
					dp[i] = min + 1;
				else
					dp[i] = -1;
			}
		}
		return dp[0];
	}

}
