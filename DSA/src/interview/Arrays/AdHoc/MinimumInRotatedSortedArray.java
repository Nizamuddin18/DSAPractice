package interview.Arrays.AdHoc;

public class MinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = {3,4,5,6,7,1,2};
		System.out.println(findMin(arr , 0 , arr.length-1));

	}

	private static int findMin(int[] arr, int start ,int end) {
		if(arr[start] == arr[end]) return start;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(mid+1 < arr.length && arr[mid] > arr[mid+1]) return mid+1;
			else if(mid-1 >= 0 && arr[mid] < arr[mid-1]) return mid;
			else if(arr[start] <= arr[mid]) start = mid+1;
			else if(arr[mid] <= arr[end]) end = mid-1;
		}
		return -1;
	}

}
