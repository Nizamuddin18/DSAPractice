package interview.Arrays.HashMap;

import java.util.HashMap;

public class LongestSubArrayEqualZeroesAndOnes {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int longestSubArrayEqualZeroesAndOnes(int[] arr) {
		HashMap<Integer , Integer> map = new HashMap<>();
		int max_length = 0;
		int i = 0;
		int sum = 0;
		map.put(0, -1); // 0 sum occurring index 
		while(i < arr.length){
			if(arr[i] == 0){
				sum += -1; // treat 0 as -1
			}else if(arr[i] == 1){
				sum += +1; //treat 1 as +1
			}
			if(map.containsKey(sum)){
				int prev_index = map.get(sum);
				int length = i - prev_index;
				max_length = Math.max(length, max_length);
			}else{
				map.put(sum, i);
			}
			
			i++;
		}

		return max_length;
	}

	public static void main(String[] args) {
		System.out.println("Longest SubArray Equal Zeroes And Ones");
		int arr[] = { 0, 1, 1, 0, 1, 1 };
		System.out.print("Input : ");
		display(arr);
		int count = longestSubArrayEqualZeroesAndOnes(arr);
		System.out.println("Output : " + count);
	}
}