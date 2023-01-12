package interview.DynamicProgramming.LCS;

public class LCSMemoize {
	public int getLCSMemoize(String x, String y , int m , int n , int dp[][]){
		if(n == 0 || m == 0)
			return 0;
		if(dp[m][n]!=-1){
			return dp[m][n];
		}
		if(x.charAt(m-1) == y.charAt(n-1)){
			return dp[m][n] = 1 + getLCSMemoize(x,y,m-1,n-1,dp);			
		}else{
			return dp[m][n] = 	Math.max(getLCSMemoize(x,y,m-1,n,dp), getLCSMemoize(x,y,m,n-1,dp));
		}
	}
}
