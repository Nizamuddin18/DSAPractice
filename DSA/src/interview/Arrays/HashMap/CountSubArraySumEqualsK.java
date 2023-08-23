package interview.Arrays.HashMap;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumEqualsK {
	public static void display(int arr[]){
		for(int  i = 0  ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int countSubArraySumEqualsK(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int sum = 0;
		map.put(sum, 1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - target)) {
				count += map.get(sum - target);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("::::: Count Sub Array Sum Equals K :::::");
		int arr[] = {1, 2, 3};
		System.out.print("Input : ");
		display(arr);
		int k = 3;
		System.out.println("K : " + k);
		int count = countSubArraySumEqualsK(arr , k);
		System.out.println("Output : " + count);

	}
	
}
