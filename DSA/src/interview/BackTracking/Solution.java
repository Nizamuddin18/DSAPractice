package interview.BackTracking;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		String str = "abc";
		dataGenerationforPermute1(str);
		dataGenerationforPermute2(str);

	}

	private static void dataGenerationforPermute2(String str) {
		System.out.println("==========================================");
		HashMap<Character, Integer> map = new HashMap<>();
		Character spots[] = new Character[str.length()];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!map.containsKey(ch))
				map.put(ch, -1);
		}
		permute2(0, map, str, spots);
	}

	private static void permute2(int ci, HashMap<Character, Integer> map, String str, Character[] spots) {
		if (ci == str.length()) {
			for (Character ch : spots)
				System.out.print(ch);
			System.out.println();
			return;
		}

		char ch = str.charAt(ci);
		int lastOccur = map.get(ch);
		for (int i = lastOccur + 1; i < spots.length; i++) {
			if (spots[i] == null) {
				spots[i] = ch;
				map.put(ch, i);
				permute2(ci + 1, map, str, spots);
				map.put(ch, -1);
				spots[i] = null;
			}
		}

	}

	private static void dataGenerationforPermute1(String str) {
		System.out.println("==========================================");
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}
		permute(0, map, str, "");
	}

	private static void permute(int level, HashMap<Character, Integer> map, String str, String asf) {
		if (level == str.length()) {
			System.out.println(asf);
			return;
		}

		// looping over map
		for (Character ch : map.keySet()) {
			int freq = map.get(ch);
			if (freq > 0) {
				map.put(ch, freq - 1);
				permute(level + 1, map, str, asf + ch);
				map.put(ch, freq);
			}
		}

	}

}
