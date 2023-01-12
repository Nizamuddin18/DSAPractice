package interview.DynamicProgramming.LPS;
import java.util.*;

public class CountDistinctSubsequences {

	public static long getCountDistinctSubsequences(String str){
		long dp[] = new long[str.length() + 1];
		dp[0] = 1;
		HashMap<Character , Integer> map = new HashMap<>();
		for(int i = 1 ; i < dp.length ; i++){
			char ch = str.charAt(i-1);
			dp[i] = 2 * dp[i-1];
			if(map.containsKey(ch)){
				int j = map.get(ch);
				dp[i] = dp[i] - dp[j-1];
			}
			map.put(ch, i);
		}	
		return dp[str.length()];	
	}
	public static void main(String[] args) {
		String str = "abcbac";
		long count = getCountDistinctSubsequences(str);
		System.out.println("Count of Distinct Subsequences for " + str + " -> " + count);
	}

}
