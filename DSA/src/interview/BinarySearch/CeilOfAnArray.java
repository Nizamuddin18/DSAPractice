package interview.BinarySearch;

public class CeilOfAnArray {
    public static void main(String[] args) {
        // Ceil is the Smallest Number >= target
        int arr[] = {2, 3, 5, 8, 9, 14, 16, 18};
        int target = 6;
        int ans = ceilOfArray(arr, target);
        System.out.println("Ceil of the Array : " + ans);
    }

    private static int ceilOfArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1; // move left
            } else {
                low = mid + 1; // move right
            }
        }
        return ans != -1 ? arr[ans] : ans;
    }
}
