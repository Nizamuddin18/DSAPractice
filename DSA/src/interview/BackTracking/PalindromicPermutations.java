package interview.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class PalindromicPermutations {

	public static void main(String[] args) {
		String str = "aaabb";
		System.out.println("Input String : " + str);
		HashMap<Character, Integer> fmap = new HashMap<>();
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(fmap.containsKey(ch))
				fmap.put(ch, fmap.get(ch) + 1);
			else
				fmap.put(ch, 1);
		}
		//check no. of odd frequency character
		Character oddCharacter = null;
		int totalOdds = 0;
		int len = 0;
		//loop for all characters in key set
		for(char ch : fmap.keySet()){ // check for all the characters in Hash Keys
			int freq = fmap.get(ch); // get the frequency of character
			if(freq % 2 == 1){ // if frequency is odd
				oddCharacter = ch;  // add to Character
				totalOdds++;
			}
			fmap.put(ch, freq / 2); // half the frequency for that character
			len = len + (freq/2); // half the length
		}
		System.out.print("Output : ");
		if(totalOdds > 1){
			System.out.println(-1);
			return;
		}

		generatepw(0 , len , fmap , oddCharacter , "" , res , new ArrayList<>());
		System.out.println(res);
	}
	
	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, 
			Character oddc, String asf , List<List<String>> res , List<String> subres) {
		//================Base Case starts===================
		if(cs == ts){
			//Reverse the answer
			String reverseString = "";
			for(int  i = asf.length() - 1; i >= 0 ; i--){
				reverseString += asf.charAt(i);
			}
			String originalString = asf;
			// if any odd frequency character is found
			// append it to reversed string
			if(oddc != null){
				originalString += oddc;			
			}
			originalString += reverseString; //append the answer and the reversed string
			//System.out.println(originalString);
			subres.add(originalString);
			res.add(new ArrayList<>(subres));
			subres.remove(subres.size()-1);
			return;
		}
		//================Base Case ends===================
		
		//we will loop through based on the no. of different charcter key set found
		for(char ch : fmap.keySet()){
			int freq = fmap.get(ch); // get the frequency for that character
			if(freq > 0){
				fmap.put(ch, freq - 1); // reduce the frequency by 1
				generatepw(cs+1 , ts , fmap , oddc , asf + ch , res , subres); // call the function 
				//Backtracking , put the frequency to original freq
				fmap.put(ch, freq); 
			}	
		}
		

	}

}


