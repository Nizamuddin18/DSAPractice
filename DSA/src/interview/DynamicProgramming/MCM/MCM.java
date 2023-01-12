package interview.DynamicProgramming.MCM;

public class MCM {

	public static void main(String[] args) {
		int matrix[] = {10, 20, 30};
		int minCost = matrxiChainMultiplication(matrix);
		System.out.println("Minimum Cost Required for Matrix Chain Multiplication : " + minCost);
	}

	private static int matrxiChainMultiplication(int[] matrix) {
		int dp[][] = new int[matrix.length-1][matrix.length-1];
		for(int g = 0 ; g < dp.length ; g++){
			for(int i = 0 , j = g ; j < dp.length ; i++ , j++){
				if(g == 0)
					dp[i][j] = 0;
				else if(g == 1)
					dp[i][j] = matrix[i] * matrix[j] * matrix[j+1];
				else{
					int minCost = Integer.MAX_VALUE;
					for(int k = i ; k < j ; k++){
						int lc = dp[i][k];
						int rc = dp[k+1][j];
						int mc = matrix[i] * matrix[k+1] * matrix[j+1];
						int tc = lc + rc + mc;
						minCost = Math.min(minCost, tc);
					}
					dp[i][j] = minCost;
				}
			}
		}
		return dp[0][dp.length-1];
	}

}
