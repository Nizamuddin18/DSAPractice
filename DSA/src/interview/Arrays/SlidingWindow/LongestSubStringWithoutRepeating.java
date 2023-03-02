package interview.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeating {

	public static void main(String[] args) {
		String str = "pwwkew";
		System.out.println(" ::::: Longest SubString with All Unique Characters ::::: ");
		int output1 = getLengthofLongestUniqueSubString1(str);
		int output2 = getLengthofLongestUniqueSubString2(str);
		System.out.println("Input   : " + str);
		System.out.println("Output1 : " + output1);
		System.out.println("Output2 : " + output2);
	}

	private static int getLengthofLongestUniqueSubString1(String str) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		while (j < str.length()) {
			char ch = str.charAt(j);

			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.size() < j - i + 1) {
				while (map.size() < j - i + 1) {
					char release = str.charAt(i);
					if (map.containsKey(release))
						map.replace(release, map.get(release) - 1);
					if (map.get(release) == 0)
						map.remove(release);
					i++;
				}
				j++;
			} else if (map.size() == j - i + 1) {
				maxLength = Math.max(maxLength, j - i + 1);
				j++;
			} else if (map.size() > j - i + 1) {
				j++;
			}
		}
		return maxLength;
	}

	public static int getLengthofLongestUniqueSubString2(String str) {
		int l = 0, r = 0;
		int len = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while (r < str.length()) {
			if (map.containsKey(str.charAt(r)))
				l = Math.max(map.get(str.charAt(r)) + 1, l);
			map.put(str.charAt(r), r);
			len = Math.max(len, r - l + 1);
			r++;
		}
		return len;

	}


}
