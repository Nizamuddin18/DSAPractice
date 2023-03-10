package interview.DynamicProgramming.LCS;

public class LCSTabulation {
	public int getLCSTabulation(String x , String y, int m , int n){
		int dp[][] = new int[m+1][n+1];
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	
	public int getLCSTabulation2(String x , String y, int m , int n){
		int dp[][] = new int[m+1][n+1];
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
					continue;
				}
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	
}
