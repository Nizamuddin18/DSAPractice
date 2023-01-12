package interview.DynamicProgramming.LCS;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		String x = "abcdeg";
		String y = "abfdeg";
		int m = x.length();
		int n = y.length();
		int dp[][] = new int[m+1][n+1];
		int count = getSubString(x,y,m,n,dp);
		System.out.println("LONGEST COMMON SUBSTRING : " + count);

	}
	
	public static int getSubString(String x , String y , int m , int n , int dp[][]){
		int max = Integer.MIN_VALUE;
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = 0;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
}
