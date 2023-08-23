package interview.BinarySearch;

public class UpperBoundInArray {

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 6, 8, 8, 11, 11, 11, 12};
        int x = 11;
        // Upper Bound -> The next Best Index which is greater than x
        // Upper Bound -> arr[index] > x
        int ans = upperBound(arr, x);
        System.out.println("Upper Bound in Array : " + ans);
    }

    private static int upperBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1; // move left
            } else {
                low = mid + 1; // move right

            }
        }
        return ans;
    }
}
