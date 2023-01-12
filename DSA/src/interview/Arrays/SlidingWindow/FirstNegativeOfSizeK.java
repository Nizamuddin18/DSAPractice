package interview.Arrays.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeOfSizeK {

	public static void main(String[] args) {
		int nums[] = { 12, -1, -7, 8, -15, 30, 16, 18 };
		int k = 3;
		List<Integer> res = firstNegativeOfSizeK(nums, k);
		System.out.println(res);
	}

	private static void display(int[] res) {
		for (int i = 0; i < res.length; i++)
			System.out.println(res[i] + " ");
		System.out.println();
	}

	private static List<Integer> firstNegativeOfSizeK(int[] nums, int k) {
		int i = 0;
		int j = 0;
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		while (j < nums.length) {
			int windowSize = j - i + 1; // check WindowSize
			// create Logic
			if (nums[j] < 0)
				queue.add(nums[j]);
			if (windowSize < k)
				j++;
			else if (windowSize == k) { // Calculations based on Logic
				if (queue.isEmpty()) {
					list.add(0);
				} else{
					list.add(queue.peek());
					if(queue.peek() == nums[i])
						queue.remove();
				}

				i++;
				j++;
			}
		}
		return list;
	}

}
