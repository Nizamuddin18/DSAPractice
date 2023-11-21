package interview.BinarySearch;

public class FloorOfAnArray {
    public static void main(String[] args) {
        // Floor is the Largest Number <= target
        int arr[] = {2, 3, 5, 8, 9, 14, 16, 18};
        int target = 2;
        int ans = floorOfArray(arr, target);
        System.out.println("Floor of the Array : " + ans);
    }

    private static int floorOfArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1; // move right
            } else {
                high = mid - 1; // move left;
            }
        }
        return ans != -1 ? arr[ans] : ans;
    }
}
