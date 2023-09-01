package interview.BinarySearch;

public class SmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        int ans = smallestDivisor(nums, threshold);
        System.out.println("Threshold : " + threshold);
        System.out.println("Output : " + ans);
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumOfDivisor(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int sumOfDivisor(int[] arr, int divisor) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / (double) divisor);
        }
        return sum;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
