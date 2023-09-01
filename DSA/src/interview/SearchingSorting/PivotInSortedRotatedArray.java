package interview.SearchingSorting;

public class PivotInSortedRotatedArray {
	private static int pivotRotatedSorted(int[] arr, int lo, int hi) {
		int mid = lo + (hi - lo)/2;
		int ans;
		if(arr[mid] < arr[hi]){
			ans = pivotRotatedSorted(arr , lo , mid);
		}else if(arr[mid] > arr[hi]){
			ans = pivotRotatedSorted(arr , mid+1 , hi);
		}else{
			ans = mid;
		}
		return ans;
	}
	private static void display(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {40 , 50 , 10, 20, 30};
		System.out.print("Input Array : ");
		display(arr);
		int pivot = pivotRotatedSorted(arr , 0 , arr.length-1);
		System.out.println("Index of Pivot in Sorted Rotated Array : " + pivot);
   
	}

	

}
