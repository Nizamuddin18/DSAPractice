package interview.Arrays.HashMap;

import java.util.HashMap;

public class LongestSubArrayEqualZeroesOnesAndTwos {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int longestSubArrayEqualZeroesOnesAndTwos(int[] arr) {
		int zerocount = 0;
		int onecount = 0;
		int twocount = 0;
		int delta10 = onecount - zerocount;
		int delta21 = twocount - onecount;
		String key = "";
		key = delta10 + "#" + delta21;
		HashMap<String, Integer> map = new HashMap<>();
		map.put(key, -1);
		int i = 0;
		int max_length = 0;
		while (i < arr.length) {
			if (arr[i] == 0) {
				zerocount++;
			} else if (arr[i] == 1) {
				onecount++;
			} else if (arr[i] == 2) {
				twocount++;
			}
			delta10 = onecount - zerocount;
			delta21 = twocount - onecount;
			key = delta10 + "#" + delta21;
			if (map.containsKey(key)) {
				int prev_index = map.get(key);
				int length =  i - prev_index;
				max_length = Math.max(max_length, length);
			} else {
				map.put(key, i);
			}
			i++;
		}
		return max_length;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 0, 1, 0 };
		System.out.print("Input : ");
		display(arr);
		int length = longestSubArrayEqualZeroesOnesAndTwos(arr);
		System.out.println("Output : " + length);
	}

}
