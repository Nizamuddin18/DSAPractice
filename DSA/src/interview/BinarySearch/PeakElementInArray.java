package interview.BinarySearch;

public class PeakElementInArray {
    public static void main(String[] args) {
        int arr[] = {7, 6, 5, 4, 3, 2, 1};
        int peak = findPeakElement(arr);
        if (peak != -1)
            System.out.println("Peak Element in Array : " + arr[peak]);
        else
            System.out.println("No Peak Element Exist");
    }

    private static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n - 1] > arr[n - 2]) return n - 1;
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if mid element is peak element
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
                return mid;
            if (arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
