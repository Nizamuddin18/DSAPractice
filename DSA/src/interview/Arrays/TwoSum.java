package interview.Arrays;

import java.util.HashMap;
// Leetcode 1 : https://leetcode.com/problems/two-sum/
public class TwoSum {

	public static int countPairs(int[] arr, int target) {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(target - arr[i])) {
				count++;
			}
			map.put(arr[i], i);
		}
		return count;
	}
	
	public static void display(int[] arr) {
		for(int  i = 0 ; i < arr.length ;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 1, 1, 1};
		System.out.print("Input : ");
		display(arr);
		int target = 2;
		int count = countPairs(arr , target);
		System.out.print("Output : " + count);
	}
}
