package interview.BinarySearch;

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int target = 3;
        boolean ans = searchInRotatedSortedArray2(arr, 0, arr.length - 1, target);
        System.out.println("Is Target Present in Sorted Rotated Array : " + ans);
    }

    private static boolean searchInRotatedSortedArray2(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return true;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            } else if (arr[low] <= arr[mid]) {
                // check if the left half is sorted
                if (arr[mid] <= target && target <= arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                // check if the right half is sorted
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
