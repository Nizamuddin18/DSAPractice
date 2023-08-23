package interview.Arrays.HashMap;

import java.util.HashMap;

public class LongestSubArraySumEqualsK {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int longestSubArraySumEqualsK(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxLength = Integer.MIN_VALUE;
		map.put(sum, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - target)) {
				int length = i - map.get(sum - target);
				maxLength = Math.max(maxLength, length);
			} else {
				map.put(sum, i);
			}
		}
		return maxLength;
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
