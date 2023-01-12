package interview.Arrays.SlidingWindow;

public class MaximumSumSubArrayOfSizeK {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 1, 8, 2, 9, 1 };
		int k = 3;
		int maxSum = maxSumSubArray(arr, k);
		System.out.println("Maximum Sum SubArray : " + maxSum);
	}

	private static int maxSumSubArray(int[] arr, int k) {
		int maxSum = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		int curr_sum = 0;
		while (j < arr.length) {
			int windowSize = j - i + 1;
			curr_sum += arr[j];

			if (windowSize < k) { // expansion
				j++;
			} else if (windowSize == k) {
				maxSum = Math.max(curr_sum, maxSum);
				curr_sum = curr_sum - arr[i]; // slide
				i++;
				j++;
			}
		}

		return maxSum;
	}
}
