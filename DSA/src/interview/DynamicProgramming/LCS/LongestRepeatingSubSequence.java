package interview.DynamicProgramming.LCS;

public class LongestRepeatingSubSequence {

	public static void main(String[] args) {
		String str = "aaabbccdee";
		int count = getRepeatingSubSequence(str);
		System.out.println("LONGEST REPEATING SUBSEQUENCE : " + count);
	}
	
	public static int getRepeatingSubSequence(String str1){
		String str2 = str1;
		int m = str1.length();
		int n = str2.length();
		int dp[][] = new int[m+1][n+1];
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1) && i!=j){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}

}
