package interview.BinarySearch;

public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int ans = minDays(bloomDay, m, k);
        System.out.println("Min Days required = " + ans);
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        if (val > bloomDay.length)
            return -1;
        int low = getMin(bloomDay);
        int high = getMax(bloomDay);
        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    private static boolean isPossible(int[] arr, int day, int m, int k) {
        int count = 0;
        int noOfBouqets = 0;
        for (int i = 0; i < arr.length; i++) {
            if (day >= arr[i]) {
                count++;
            } else {
                noOfBouqets += (count / k);
                count = 0;
            }
        }
        noOfBouqets += (count / k);
        return noOfBouqets >= m;
    }
}
