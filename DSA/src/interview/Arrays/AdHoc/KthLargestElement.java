package interview.Arrays.AdHoc;

import java.util.PriorityQueue;

public class KthLargestElement {
	// quick select main logic where kth largest no is returned
	public static int kthLargest2(int[] arr, int lo, int hi, int k) {
		if (k < 0)
			return -1;
		int pivot = arr[hi];
		int pi = partition(arr, pivot, lo, hi);
		int ans;
		if (pi == k) {
			// Partition Index is equal to Kth Element
			ans = pivot;
		} else if (pi > k) {
			// k lesser than partition Index , then we check left side of
			// Partitioned Array
			ans = kthLargest2(arr, lo, pi - 1, k);
		} else {
			// k is greater than partition Index , then we check right side of
			// Partitioned Array
			ans = kthLargest2(arr, pi + 1, hi, k);
		}
		return ans;
	}

	// used to partition based on pivot element
	public static int partition(int[] arr, int pivot, int lo, int hi) {
		int i = lo, j = lo;
		while (i <= hi) {
			if (arr[i] >= pivot) {
				swap(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
		// System.out.println("pivot index -> " + (j - 1));
		return (j - 1);
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// display
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int findKthLargestElement(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1);
		for(int i = 0;i<arr.length;i++){
			pq.add(arr[i]);
			if(pq.size() > k){
				pq.remove();
			}
		}
		return pq.peek();
	}
	
	public static void main(String[] args) {
		int arr[] = { 3, 1,2,4,8,6,7,5};
		int k = 3;
		int l1= findKthLargestElement(arr , k);
		int l2 = kthLargest2(arr , 0 , arr.length-1 , k-1);
		System.out.println("kth Largest Element Using Heap     : " + l1);
		System.out.println("kth Largest Element Using QuickSelect : " + l2);
	}
}
