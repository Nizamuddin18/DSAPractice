package interview.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations1 {

	private static void combinationsBoxesOnLevelOrder(int currentLevel, int totalLevels, 
									int totalItems, int currentOption, String asf) {
		if(currentLevel > totalLevels){
			if(currentOption == totalItems){
				System.out.println(asf);
			}
			return;
		}
		combinationsBoxesOnLevelOrder(currentLevel + 1 , totalLevels , totalItems , 
										currentOption + 1 , asf + currentLevel + "");
		combinationsBoxesOnLevelOrder(currentLevel + 1 , totalLevels , totalItems , 
										currentOption , asf  + "");
	}
	
	
	// =========================== LeetCode 77 ============================
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> mainList = new ArrayList<>();
		combinations(1 , n , k , 0 , mainList , new ArrayList<Integer>());
		return mainList; 
    }

	private static void combinations(int curlevel, int totalLevel, int totalitems, int currentBox, 
										List<List<Integer>> mainList, ArrayList<Integer> list) {
		if(curlevel > totalLevel){
			if(currentBox == totalitems){
				mainList.add(new ArrayList<>(list));
			}
			return;
		}
		
		list.add(curlevel);
		combinations(curlevel + 1 , totalLevel , totalitems , currentBox + 1, mainList , list);
		
		list.remove(list.size()-1);
		combinations(curlevel + 1 , totalLevel , totalitems , currentBox , mainList , list);

	}

	public static void main(String[] args) {
		int levels = 4;
		int items = 2;
		combinationsBoxesOnLevelOrder(1 , levels , items , 0 , "");
		//System.out.println(combine(levels , items));
	}

}
