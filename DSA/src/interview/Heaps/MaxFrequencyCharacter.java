package interview.Heaps;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyCharacter {
	public static char getMaxFrequencyCharacter(String str){
		Map<Character , Integer> map = new HashMap<>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch) == true)
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}
		//Calculate Max Frequency
		char ch = '\0';
		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()){
			if(max < map.get(key)){
				max = map.get(key);
				ch = key;
			}
		}
		Map.Entry<Character, Integer> maxEntry = map.entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		return maxEntry.getKey();
//		return ch;
	}
	
	public static void main(String[] args) {
		System.out.println("::::: Max Frequency Character :::::");
		String str = "zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc";
		System.out.println("Input   : " + str);
		char maxFreq = getMaxFrequencyCharacter(str);
		System.out.println("Output  : " + maxFreq);
	}

}
