package interview.BackTracking;

import java.util.HashMap;
import java.util.Scanner;
public class Cryptarithmetic {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	    String s1 = "send";
	    String s2 = "more";
	    String s3 = "money";

	    HashMap<Character, Integer> charIntMap = new HashMap<>();
	    String unique = "";
	    for (int i = 0; i < s1.length(); i++) {
	      if (!charIntMap.containsKey(s1.charAt(i))) {
	        charIntMap.put(s1.charAt(i), -1);
	        unique += s1.charAt(i);
	      }
	    }

	    for (int i = 0; i < s2.length(); i++) {
	      if (!charIntMap.containsKey(s2.charAt(i))) {
	        charIntMap.put(s2.charAt(i), -1);
	        unique += s2.charAt(i);
	      }
	    }

	    for (int i = 0; i < s3.length(); i++) {
	      if (!charIntMap.containsKey(s3.charAt(i))) {
	        charIntMap.put(s3.charAt(i), -1);
	        unique += s3.charAt(i);
	      }
	    }

	    boolean[] usedNumbers = new boolean[10];
	    solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);

	}
	
	private static void solution (String unique, int idx, 
			  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
			  String s1, String s2, String s3){
		//================Base Case starts===================
		// it is not guaranteed that all the mapping will lead to s1+s2 = s3
		if(unique.length() == idx){
			int num1 = getNum(s1 , charIntMap);
			int num2 = getNum(s2 , charIntMap);
			int num3 = getNum(s3 , charIntMap);
			if(num1 + num2 == num3){ // if condition matches
				for(int  i = 0;i< 26; i++){ // for ascending order printing
					char ch = (char)('a' + i);
					if(charIntMap.containsKey(ch)){
						System.out.print(ch + " - " + charIntMap.get(ch) + " ");
					}	
				}
				System.out.println();
			}
			return;
		}
		//================Base Case ends===================

		// take the character based on index , initially passed as 0
		char ch = unique.charAt(idx);
		for(int  i = 0; i <=9 ; i++){
			if(usedNumbers[i] == false){ // if the number is still not used
				charIntMap.put(ch, i); // add the number to hashmap
				usedNumbers[i] = true; // mark it
				solution(unique , idx + 1 , charIntMap , usedNumbers , s1 , s2 , s3); // call for the next index
				//Backtracking
				charIntMap.put(ch, -1);
				usedNumbers[i] = false;
			}		
		}
	}

	private static int getNum(String s1, HashMap<Character, Integer> charIntMap) {
		String num = "";
		for(int  i = 0; i< s1.length();i++){ // loop through all the charcters
			num = num + charIntMap.get(s1.charAt(i)); // take their value from hashmap and add to string
		}
		return Integer.parseInt(num); // return the string as Integer
	}

}
