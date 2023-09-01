package interview.SearchingSorting;

public class MergeSort {
	private static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		int k = 0;
		int res[] = new int[arr1.length + arr2.length];
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j])
				res[k++] = arr1[i++];
			else
				res[k++] = arr2[j++];	
		}	
		while(i < arr1.length)
			res[k++] = arr1[i++];
		while(j < arr2.length)
			res[k++] = arr2[j++];
		return res;
	}
	private static int[] mergeSort(int[] arr , int lo , int hi) {
		if(lo == hi){
			int bres[] = new int[1];
			bres[0] = arr[lo];
			return bres;
		}
		int mid = lo + (hi - lo)/2;
		int arr1[] = mergeSort(arr , lo , mid);
		int arr2[] = mergeSort(arr , mid+1 , hi);
		int merged[] = mergeTwoSortedArray(arr1 , arr2);
		return merged;
	}
	private static void display(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[] = {5,-1,4,7,9,0,2};
		System.out.print("Array before Sorting : ");
		display(arr);
		int sorted[] = mergeSort(arr , 0 , arr.length-1);
		System.out.print("Array after  Sorting : ");
		display(sorted);
		System.out.print("Original Array after Sorting : ");
		display(arr);
	}
}
