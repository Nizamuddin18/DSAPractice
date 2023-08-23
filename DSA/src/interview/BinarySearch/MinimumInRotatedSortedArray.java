package interview.BinarySearch;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int min2 = findMin2(arr, 0, arr.length - 1);
        System.out.println("Minimum in Sorted Rotated Array : " + min2);
    }

    private static int findMin2(int[] arr, int low, int high) {
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                // left half is sorted
                min = Math.min(min, arr[low]);
                // eliminate left half
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                // right half is sorted
                min = Math.min(min, arr[mid]);
                // eliminate right half
                high = mid - 1;
            }
        }
        return min;
    }

}
