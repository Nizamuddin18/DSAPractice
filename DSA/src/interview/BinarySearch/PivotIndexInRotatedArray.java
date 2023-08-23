package interview.BinarySearch;

public class PivotIndexInRotatedArray {
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 1, 2};
        int pivot = findPivotElement(arr);
        System.out.println("Pivot Element in Array : " + pivot);
    }

    private static int findPivotElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int pivot = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[high]) {
                if (arr[low] < min) {
                    min = arr[low];
                    pivot = low;
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    pivot = low;
                }
                low = mid + 1;

            } else if (arr[mid] <= arr[high]) {
                if (arr[mid] < min) {
                    min = arr[mid];
                    pivot = mid;
                }
                high = mid - 1;

            }
        }
        return pivot;
    }
}
