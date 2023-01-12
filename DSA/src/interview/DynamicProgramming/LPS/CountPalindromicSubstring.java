package interview.DynamicProgramming.LPS;

public class CountPalindromicSubstring {
	
	public static int getCountPalindromicSubstring(String str){
		boolean dp[][] = new boolean[str.length()][str.length()];
		int count = 0;
		for(int gap = 0 ; gap < str.length() ; gap++){
			for(int i = 0, j = gap; j < dp.length ; i++, j++){
				if(gap == 0)
					dp[i][j] = true;
				else if(gap == 1){
					dp[i][j] = str.charAt(i) == str.charAt(j) ? true : false;
				}else{
					if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true){
						dp[i][j] = true;
					}else{
						dp[i][j] = false;
					}
				}
				if(dp[i][j])
					count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String str = "aaa";
		int count = getCountPalindromicSubstring(str);
		System.out.println("Input : " + str);
		System.out.println("Count of Palindromic Substring : " + count);
	}

}
