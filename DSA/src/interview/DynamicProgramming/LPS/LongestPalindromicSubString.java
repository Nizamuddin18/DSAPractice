package interview.DynamicProgramming.LPS;

public class LongestPalindromicSubString {
	
	public static String reverse(String str){
		String ret = "";
		for(int  i = 0; i < str.length() ; i++){
			char ch = str.charAt(i);
			ret = ch + ret;
		}
		return ret;
	}
	
	public int getPlaindromicSubsString1(String str1){
		String str2 = reverse(str1);
		int m = str1.length();
		int n = str2.length();
		int max = Integer.MIN_VALUE;
		int dp[][] = new int[m+1][n+1];
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = 0;
				}
				max = Math.max(dp[i][j], max);
			}
		}
		return max;
	}
	
	public int getPlaindromicSubsString2(String str){
		int m = str.length();
		int length = 0;
		boolean dp[][] = new boolean[m][m];
		for(int gap = 0 ; gap < str.length() ; gap++){
			for(int i = 0 , j = gap ; j < dp.length ; i++ , j++){
				if(gap == 0)
					dp[i][j] = true;
				else if(gap == 1)
					dp[i][j] = str.charAt(i) == str.charAt(j) ? true : false;
				else{
					if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true)
						dp[i][j] = true;
					else
						dp[i][j] = false;	
				}
				if(dp[i][j] == true)
					length = gap + 1;
			}
		}
		return length;
	}
	
	public static void display(int dp[][]){
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubString lpss = new LongestPalindromicSubString();
		String str = "abccbc";
		int lpss1 = lpss.getPlaindromicSubsString1(str);
		System.out.println("Longest Palindromic Substring1 : " + lpss1);
		int lpss2 = lpss.getPlaindromicSubsString2(str);
		System.out.println("Longest Palindromic Substring2 : " + lpss2);
	}
}
