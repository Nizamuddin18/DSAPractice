package interview.Arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// LeetCode : 3 https://leetcode.com/problems/3sum/
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		int target = 0;
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) 
				continue;
			int val1 = nums[i];
			int smalltarget = target - val1;
			List<List<Integer>> subres = twoSum(nums, i + 1, nums.length - 1, smalltarget);
			for (List<Integer> list : subres) {
				list.add(val1);
				res.add(list);
			}
		}
		return res;
	}

	public static List<List<Integer>> twoSum(int[] arr, int start, int end, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int left = start;
		int right = end;
		while (left < right) {
			// pre-processing
			if (left != start && arr[left] == arr[left - 1]) {
				left++;
				continue;
			}
			int sum = arr[left] + arr[right];
			if (sum == target) {
				List<Integer> subres = new ArrayList<>();
				subres.add(arr[left]);
				subres.add(arr[right]);
				res.add(subres);
				left++;
				right--;
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = {-1 ,0 ,1 ,2 ,-1 ,-4};
		int target = 0;
		List<List<Integer>> ans = threeSum(arr);
		System.out.println(ans);
	}

}
