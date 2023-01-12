package interview.BackTracking;

import java.util.HashMap;

public class PermutationsWords2 {

	/*
	Unique Character Map is is on Level;
	Character Spots to be placed is on Option;
	*/
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println("Input : " + str);
		Character spots[] = new Character[str.length()]; // [null,null,null]

		HashMap<Character, Integer> fmap = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if(!fmap.containsKey(ch))
				fmap.put(ch, -1);
		}
		// {1=-1 , 2=-1 , 3=-1}
		generateWords(0, str, spots, fmap);
	}

	private static void generateWords(int curindex, String str, Character[] spots , 
								HashMap<Character, Integer> map) {
		if (curindex == str.length()) {
			for (int i = 0; i < spots.length; i++) {
				System.out.print(spots[i]);
			}
			System.out.println();
			return;
		}
		
		char ch = str.charAt(curindex); // 1
		int lo = map.get(ch); 			// get the last occurence of that character
		for (int i = lo + 1; i < spots.length; i++) {
			if (spots[i] == null) {
				spots[i] = ch;
				map.put(ch, i);
				generateWords(curindex + 1, str, spots, map);
				map.put(ch, -1);
				spots[i] = null;
			}
		}
	}
}
