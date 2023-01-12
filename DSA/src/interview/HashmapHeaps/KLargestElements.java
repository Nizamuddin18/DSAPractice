package interview.HashmapHeaps;

import java.util.PriorityQueue;

public class KLargestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1,23,12,9,30,2,50};
		int size = arr.length;
		int k = 3;
		findKLargestElements(arr, size , k);
	}

	private static void findKLargestElements(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i < size ; i++){	
			//add first k elements in Priority Queue
			if(i < k){
				pq.add(arr[i]);
			}else{//check for rest of elements
				if(arr[i] >= pq.peek()){
					pq.remove(); // remove from Priority Queue
					pq.add(arr[i]); // add
				}
			}
		}
		//display
		while(!pq.isEmpty())
			System.out.println(pq.remove());
	}

}
