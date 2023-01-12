package interview.HashmapHeaps;

import java.util.PriorityQueue;

public class KthLargest {
	
	public static void main(String[] args) {
		int arr[] = {-1,10,8,9,12,-8,11};
		int size = arr.length;
		int k = 3;
		System.out.println("::::: Kth Largest Element :::::");
		int kthLargestElement1 = findKthLargestElement1(arr, size , k);
		int kthLargestElement2 = findKthLargestElement2(arr, size , k);
		System.out.print("Input  : ");
		for(Integer i : arr)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Output1 : " + kthLargestElement1);
		System.out.println("Output1 : " + kthLargestElement2);
	}

	private static int findKthLargestElement1(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i<arr.length;i++){
			pq.add(arr[i]);
			if(pq.size() > k){
				pq.remove();
			}
		}
		return pq.peek();
	}
	
	private static int findKthLargestElement2(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0;i<arr.length;i++){
			if(i < k)
				pq.add(arr[i]);
			else{
				if(arr[i] > pq.peek()){
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		return pq.peek();
	}
	
}
