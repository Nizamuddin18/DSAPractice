package interview.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KWordsSelection1 {

	public static void main(String[] args) {
		String str = "1232";
		System.out.println("Input : " + str);
		int  k = 2;
		HashSet<Character> set = new HashSet<>();
		String unique = "";
		for(char ch : str.toCharArray()){
			if(!set.contains(ch)){
				set.add(ch);
				unique = unique + ch;
			}
		}
		//kwordsSelection(0 , unique, ""  ,k , 0);
		List<List<Character>> res = new ArrayList<>();
		kwords(0 , unique , new ArrayList<>() , res , k , 0);
		System.out.println("Output : " + res);
	}

	public static void kwords(int curitem , String unique , List<Character> subres , List<List<Character>> res,
			int k , int selection){
		if(curitem == unique.length()){
			if(selection == k){
				res.add(new ArrayList<>(subres));
			}
			return;
		}
		
		char ch = unique.charAt(curitem);
		subres.add(ch);
		kwords(curitem+1 , unique , subres , res , k , selection+1);
		subres.remove(subres.size()-1);
		
		kwords(curitem+1 , unique , subres , res , k , selection);
	}
	
	
	private static void kwordsSelection(int curItems, String unique, String asf, int k , int selSoFar) {
		if(curItems == unique.length()){
			if(selSoFar == k){
				System.out.println(asf + " ");
			}
			return;
		}
		char ch = unique.charAt(curItems);
		kwordsSelection(curItems + 1 , unique , asf + ch, k , selSoFar+1);
		kwordsSelection(curItems + 1 , unique , asf + "", k  ,  selSoFar);
	}

}
