package interview.Arrays;

import java.util.HashMap;

public class LongestSubArrayWith0Sum {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int largestSubArrayWith0SumBruteForce(int[] arr) {
		// generate all possible sub-array
		int len = 0, max_len = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == 0)
					len = j - i + 1;
			}
			max_len = Math.max(max_len, len);
		}
		return max_len;
	}

	public static int largestSubArrayWith0SumOptimal(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int max_len = 0;
		map.put(sum, -1); 
		for(int i = 0 ; i < arr.length ; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) { // same sum already exist
				int len = i - map.get(sum);
				max_len = Math.max(len, max_len);
			} else {
				map.put(sum, i);
			}
		}
		return max_len;
	}

	public static void main(String[] args) {
		System.out.println("::::: Largest SubArray With 0 Sum");

		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23};
		System.out.print("Input : ");
		display(arr);
		int bruteForce = largestSubArrayWith0SumBruteForce(arr);
		int optimal = largestSubArrayWith0SumOptimal(arr);
		System.out.println("Output(Brute Force) 	: " + bruteForce);
		System.out.println("Output(Optimal) 	: " + optimal);
	}

}
