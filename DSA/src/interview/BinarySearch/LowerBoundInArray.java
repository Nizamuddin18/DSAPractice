package interview.BinarySearch;

public class LowerBoundInArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 3, 5, 8, 8, 10, 10, 11};
        int x = 1;
        // Lower Bound -> The next Best Index which is greater than equal to x
        // Lower Bound -> arr[index] >= x
        int ans = lowerBound(arr, x);
        System.out.println("Lower Bound in Array : " + ans);
    }

    private static int lowerBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1; // move left
            } else {
                low = mid + 1; // move right
            }
        }
        return ans;
    }
}
