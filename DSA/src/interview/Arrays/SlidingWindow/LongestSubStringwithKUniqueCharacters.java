package interview.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
public class LongestSubStringwithKUniqueCharacters {

	public static void main(String[] args) {
		String str = "WORLD";
		int k = 4;
		int maxLength = longestSubStringwithKUniqueCharacters(str , k);
		System.out.println("Max Length : " + maxLength);
	}
	
	private static int longestSubStringwithKUniqueCharacters(String str , int k){
		Map<Character , Integer> map = new HashMap<>();
		int maxLength = Integer.MIN_VALUE;
		int i = 0 ; 
		int j = 0;
		while(j < str.length()){
			char ch = str.charAt(j);
			if(map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
			
			if(map.size() < k){
				j++;
			}else if(map.size() == k){
				int window = j-i+1;
				maxLength = Math.max(maxLength, window);
				j++;
			}else if(map.size() > k){
				while(map.size() > k){
					char ch_rem = str.charAt(i);
					int prev = map.get(ch_rem);
					map.put(ch_rem, prev-1);
					if(map.get(ch_rem) == 0)
						map.remove(ch_rem);
					i++;
				}
				j++;
			}
		}
		return maxLength;
	}
}
