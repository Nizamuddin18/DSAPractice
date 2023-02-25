package interview.Heaps;

import java.util.HashMap;

public class LongestSubStringWithoutRepeating {

	public static void main(String[] args) {
		String str = "abcaabcdba";
		int ret_val = getLengthofLongestSubString(str);
		System.out.println("Length of Longest SubString without Repeating Characters : " + ret_val);

	}
	public static int getLengthofLongestSubString(String str){	
		int l = 0, r = 0;
		int len = 0;
		HashMap<Character , Integer> map = new HashMap<>();
		while(r < str.length()){
			if(map.containsKey(str.charAt(r)))
				l = Math.max(map.get(str.charAt(r)) +1 , l);
			map.put(str.charAt(r), r);
			len = Math.max(len, r-l+1);
			r++;
		}
		return len;
		
	}
}
