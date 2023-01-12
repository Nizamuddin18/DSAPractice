package interview.HashmapHeaps;

import java.util.PriorityQueue;

public class KSortedArray {
	
	private static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {6,5,3,2,8,10,9};
		int size = arr.length;
		int k = 3;
		
		System.out.print("Input arr: ");
		display(arr);
		int res_arr[] = kSortedArray(arr, size , k);
		System.out.print("Output arr: ");
		display(res_arr);
	}

	private static int[] kSortedArray(int[] arr, int size, int k) {
		int pos = 0;
		int val;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i< size ; i++){
			pq.add(arr[i]); // add elements 
			if(i >= k){ // when i index crosses k
				val = pq.remove(); // remove (Min value is returned)
				arr[pos++] = val; // add it to correct pos
			}
		}
		//solve for remaining elements
		while(pq.size() > 0){
			val = pq.remove();
			arr[pos++] = val;
		}
		return arr;
	}
}
