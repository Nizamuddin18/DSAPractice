package interview.BinarySearch;

public class FirstOccurenceOfNumber {
    public static int findFirstOccurrence1(int arr[], int low, int high, int data) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == data && low == mid || arr[mid] == data && arr[mid - 1] < data) {
                return mid;
            } else if (arr[mid - 1] < data) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

	private static int findFirstOccurrence2(int[] arr, int low, int high, int target) {
		int ans = arr.length;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(arr[mid] >= target){
				ans = mid;
				high = mid - 1; // move left
			}else{
				low = mid + 1; // move right
			}
		}

		if(ans == arr.length || arr[ans] != target) return -1;
		return ans;
	}

    public static void main(String[] args) {
        int arr[] = {3, 5, 5, 5, 6, 6, 7, 7, 7, 9};
        int data = 10;
        int firstOccur1 = findFirstOccurrence1(arr, 0, arr.length - 1, data);
		int firstOccur2 = findFirstOccurrence2(arr, 0, arr.length - 1, data);
        System.out.println("Method 1 : First Occurrence of " + data + " found at Index : " + firstOccur1);
		System.out.println("Method 2 : First Occurrence of " + data + " found at Index : " + firstOccur2);

	}


}
