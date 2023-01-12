package interview.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int nums[] = {1,2,3};
		int index = 0;
		List<List<Integer>> list = subsets(nums , index);
		System.out.println(list);

	}

	public static List<List<Integer>> subsets(int[] nums, int index) {
		List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>(), 0);
        return res;

	}

	private static void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        
        for(int i=start; i<nums.length; i++) {
            list.add(nums[i]);
            backtrack(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
