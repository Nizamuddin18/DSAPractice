package interview.Arrays;

import java.util.HashMap;

public class LongestSubArraySumEqualsK {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int longestSubArraySumEqualsK(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int sum = 0;
		int max_length = 0;
		map.put(0, -1);
		while (i < arr.length) {
			sum += arr[i];
			int deltasum = sum - k;
			if (map.containsKey(deltasum)) {
				int prev_index = map.get(deltasum);
				int length = i - prev_index;
				max_length = Math.max(max_length, length);
			} else {
				map.put(sum, i);
			}

			i++;
		}
		return max_length;
	}
	
	public static int longestSubArraySumEqualsKSlidingWindow(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int max_length = 0;
		while(j < arr.length){
			sum += arr[j];
			if(sum == k){
				int length = j - i + 1;
				max_length = Math.max(max_length, length);
				sum = sum - arr[i];
				i++;
				j++;
			}else if(sum < k){
				j++;
			}else {
				while(sum > k){
					sum = sum - arr[i];
                    i++;
                    if(sum == k){
                    	int length = j - i + 1;
                    	max_length = Math.max(max_length,length);
                    }
				}
				j++;
			}
		}
		return max_length;
	}
	
	public static void main(String[] args) {
		System.out.println("::::: Longest Sub Array Sum Equals K :::::");
		int arr[] = {10, 5, 2, 7, 1, 9 };
		System.out.print("Input : ");
		display(arr);
		int k = 15;
		System.out.println("K : " + k);
		int length = longestSubArraySumEqualsK(arr, k);
		int length2 = longestSubArraySumEqualsKSlidingWindow(arr, k);
		System.out.println("Output : " + length);
		System.out.println("Output : " + length2);

	}

	

}
