package interview.Arrays;

import java.util.HashMap;

public class LongestSubArraySumDivisibleByK {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int longestSubArraySumDivisbleByK(int arr[], int k) {
		int max_count = 0;
		int i = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		while (i < arr.length) {
			sum += arr[i];
			int rem = sum % k;
			if (k < 0)
				rem += k;

			if (map.containsKey(rem)) {
				int count = i - map.get(rem);
				max_count = Math.max(count, max_count);
			} else {
				map.put(rem, i);
			}
			i++;
		}
		return max_count;
	}

	public static void main(String[] args) {
		int arr[] = { -2, 2, -5, 12, -11, -1, 7 };
		int k = 3;
		System.out.print("Input : ");
		display(arr);
		System.out.println("K : " + k);
		int count = longestSubArraySumDivisbleByK(arr, k);
		System.out.println("Output : " + count);
	}

}
