package interview.Arrays;

import java.util.HashMap;

public class CountSubArrayEqualZeroesAndOnes {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int countSubArrayEqualZeroesAndOnes(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int i = 0;
		int sum = 0;
		map.put(0, 1); // 0 sum occurring index
		while (i < arr.length) {
			if (arr[i] == 0) {
				sum += -1; // treat 0 as -1
			} else if (arr[i] == 1) {
				sum += +1; // treat 1 as +1
			}
			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}

			i++;
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println("Count SubArray Equal Zeroes And Ones");
		int arr[] = { 0, 1, 1, 0, 1, 1 };
		System.out.print("Input : ");
		display(arr);
		int count = countSubArrayEqualZeroesAndOnes(arr);
		System.out.println("Output : " + count);

	}

}
