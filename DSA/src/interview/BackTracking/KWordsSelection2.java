package interview.BackTracking;

import java.util.HashSet;

public class KWordsSelection2 {

	public static void main(String[] args) {
		String str = "1232";
		int k = 2;
		HashSet<Character> set = new HashSet<>();
		String unique = "";
		for (char ch : str.toCharArray()) {
			if (!set.contains(ch)) {
				set.add(ch);
				unique = unique + ch;
			}
		}
		System.out.println("Unique String : " + unique);
		kwordsSelection2(1, unique, "", k, -1);

	}

	private static void kwordsSelection2(int curItems, String unique, String asf, int totItems, 
										int lastOccurence) {
		if (curItems > totItems) {
			System.out.println(asf);
			return;
		}
		for (int i = lastOccurence + 1; i < unique.length(); i++) {
			char ch = unique.charAt(i);
			kwordsSelection2(curItems + 1, unique, asf + ch, totItems, i);
		}
	}

}
