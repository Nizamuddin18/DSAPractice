package interview.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class PermutationsWords1 {
	
	/*Current box or Place is on Level;
	Unique Character is on Option*/
	
	public static void main(String[] args) {
		/*String str = "123";
		System.out.println("Input : " + str);
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch) + 1);
			} else {
				fmap.put(ch, 1);
			}
		}
		System.out.println("Output : ");
		generateWords(1, str.length(), fmap, "");
		*/
		int arr[] = {1,2,3};
		System.out.println(permuteUnique(arr));
	}
	
	private static void generateWords(int cs, int ts, HashMap<Character, Integer> map, String asf) {
		if (cs > ts) {
			System.out.println(asf + " ");
			return;
		}

		for (char ch : map.keySet()) {
			int freq = map.get(ch);
			if (freq > 0) {
				map.put(ch, freq - 1);
				generateWords(cs + 1, ts, map, asf + ch);
				// Backtrack
				map.put(ch, freq);
			}
		}
	}
	
	// ============================================== LeetCode 47 ================================
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> mainList = new ArrayList<>();
		//boolean vis[] = new boolean[nums.length];
		HashMap<Integer, Integer> fmap = new HashMap<>();
		for (Integer i : nums) {
			if (fmap.containsKey(i)) {
				fmap.put(i, fmap.get(i) + 1);
			} else {
				fmap.put(i, 1);
			}
		}
		generateWords2(0, mainList, new ArrayList<Integer>(), nums, fmap);
		return mainList;
    }
	
	private static void generateWords2(int curlevel, List<List<Integer>> mainList, 
			ArrayList<Integer> list, int[] nums, HashMap<Integer, Integer> map) {
		if(curlevel == nums.length){
			mainList.add(new ArrayList<Integer>(list));
			return;
		}
		for(Integer i: map.keySet()){
			int freq = map.get(i);
			if(freq > 0){
				map.put(i, freq-1);
				list.add(i);
				generateWords2(curlevel+1 , mainList , list , nums , map);
				list.remove(list.size()-1);
				map.put(i, freq);
			}
		}
		return;
	}


	// ============================================== LeetCode 46 =================================
	
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		boolean vis[] = new boolean[nums.length];
		generateWords1(0 , res, new ArrayList<Integer>() , nums, vis);
		return res;
    }
	
	public static void generateWords1(int curlevel , List<List<Integer>> mainList, 
			List<Integer> list, int[] nums, boolean vis[]) {
		if (curlevel == nums.length) {
			mainList.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < nums.length ; i++) {
			if (vis[i] == false) {
				list.add(nums[i]);
				vis[i] = true;
				generateWords1(curlevel + 1 , mainList, list , nums, vis);
				list.remove(list.size() - 1);
				vis[i] = false;
			}
		}
	}
	 

}
