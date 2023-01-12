package interview.DynamicProgramming.LPS;

public class CountPalindromicSubsequence {
	
	public static int getCountPalindromicSubsequence(String str){
		int dp[][] = new int[str.length()][str.length()];
		for(int gap = 0 ; gap < str.length() ; gap++){
			for(int i = 0 , j = gap ; j < str.length() ; i++ , j++){
				if(gap == 0){
					dp[i][j] = 1;
				}else if(gap == 1){
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = 3;
					else
						dp[i][j] = 2;
				}else{
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1;
					else
						dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
				}
			}
		}
		return dp[0][str.length()-1];
	}

	public static void main(String[] args) {
		String str = "bccb";
		System.out.println("Input : " + str);
		int count = getCountPalindromicSubsequence(str);
		System.out.println("Count of Palindromic Subsequence : " + count);
	}

}
