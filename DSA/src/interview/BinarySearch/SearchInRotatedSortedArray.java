package interview.BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 8, 9, 10, 1, 2};
        int target = 11;
        int ans = searchInRotatedSortedArray(arr, 0, arr.length - 1, target);
        System.out.println("Index of Target in Sorted Rotated Array : " + ans);
    }

    private static int searchInRotatedSortedArray(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[low] <= arr[mid]) {
                // Left Half of the Array is Sorted
                if (arr[low] <= target && target <= arr[mid]) {
                    // element lies in the left Half of the Array -> Eliminate the Right Half
                    high = mid - 1; // move left
                } else {
                    low = mid + 1; // move right
                }
            } else {
                // Right Half of the Array is Sorted
                if (arr[mid] <= target && target <= arr[high]) {
                    // element lies in the right Half of the Array -> Eliminate the Left Half
                    low = mid + 1; // move right
                } else {
                    high = mid - 1; // move left
                }
            }
        }
        return -1;
    }
}
