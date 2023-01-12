package interview.DynamicProgramming.LPS;

public class LongestPalindromicSubsequence {
	
	public int getPalindromicSubSequence2(String str){
		int dp[][] = new int[str.length()][str.length()];
		
		for(int gap = 0 ; gap < str.length() ; gap++){
			for(int i = 0 ,j = gap ; j < dp.length ; i++ , j++){
				if(gap == 0)
					dp[i][j] = 1;
				else if(gap == 1)
					dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
				else{
					if(str.charAt(i) == str.charAt(j))
						dp[i][j] = 2 + dp[i+1][j-1];
					else
						dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		display(dp);
		return dp[0][str.length()-1];
	}
	
	public int getPalindromicSubSequence1(String str1){
		String str2 = reverse(str1);
		int m = str1.length();
		int n = str2.length();
		int dp[][] = new int[m+1][n+1];
		
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		display(dp);
		return dp[m][n];
		
	}
	
	public static void display(int dp[][]){
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}
	
	public static String reverse(String str){
		String ret = "";
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			ret = ch + ret;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str1 = "abccbc";
		int lps1 = lps.getPalindromicSubSequence1(str1);
		System.out.println("Longest Palindromic Subsequence1 : " + lps1);
		int lps2 = lps.getPalindromicSubSequence2(str1);
		System.out.println("Longest Palindromic Subsequence2 : " + lps2);
	}
	

}
