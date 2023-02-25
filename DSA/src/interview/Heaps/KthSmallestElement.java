package interview.Heaps;
import java.util.Collections;
import java.util.PriorityQueue;
public class KthSmallestElement {

	public static void main(String[] args) {
		int arr[] = {-1,10,8,9,12,-8,11};
		int size = arr.length;
		int k = 3;
		System.out.println("::::: Kth Smallest Element :::::");
		int kthSmallestElement = findKthSamllestElement(arr, size , k);
		System.out.print("Input  : ");
		for(Integer i : arr)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Output : " + kthSmallestElement);

	}

	private static int findKthSamllestElement(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0 ; i < arr.length ; i++){
			if(i < k)
				pq.add(arr[i]);
			else{
				if(arr[i] <= pq.peek()){
					pq.remove(); 	// remove from Priority Queue
					pq.add(arr[i]); // add
				}
			}	
		}
		return pq.peek();
	}

}
