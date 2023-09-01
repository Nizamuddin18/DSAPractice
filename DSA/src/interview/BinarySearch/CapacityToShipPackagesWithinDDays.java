package interview.BinarySearch;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        int ans = shipWithinDays(weights, days);
        System.out.println("Output : " + ans);
    }

    private static int shipWithinDays(int[] weights, int days) {
        int sum = findSumOfAllWeights(weights);
        int max = findMaxOfAllWeights(weights);
        int low = max;
        int high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int noOfDays = calculateNoOfDays(weights, mid);
            if (noOfDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int calculateNoOfDays(int[] weights, int capacity) {
        int noOfDays = 1;
        int totalLoad = 0;
        for (int i = 0; i < weights.length; i++) {
            if (totalLoad + weights[i] > capacity) {
                noOfDays++;
                totalLoad = weights[i];
            } else {
                totalLoad += weights[i];
            }
        }
        return noOfDays;
    }

    private static int findMaxOfAllWeights(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++)
            max = Math.max(max, weights[i]);
        return max;
    }

    private static int findSumOfAllWeights(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++)
            sum += weights[i];
        return sum;
    }


}
