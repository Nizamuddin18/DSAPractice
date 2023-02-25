package interview.Arrays.SlidingWindow;

public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int arr[] = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        int maxSum = maxSumSubArray(arr, k);
        System.out.println("::::: Maximum Sum Sub-Array Of Size K :::::");
        System.out.print("Input  : ");
        for(int num : arr)
            System.out.print(num + " ");
        System.out.println();
        System.out.println("K : " + k);
        System.out.println("Output : " + maxSum);
    }

    private static int maxSumSubArray(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int curr_sum = 0;
        while (end < arr.length) {
            int windowSize = end - start + 1;
            curr_sum += arr[end];

            if (windowSize < k) { // expansion
                end++;
            } else if (windowSize == k) {
                maxSum = Math.max(curr_sum, maxSum);
                curr_sum = curr_sum - arr[start]; // slide
                start++;
                end++;
            }
        }
        return maxSum;
    }
}
