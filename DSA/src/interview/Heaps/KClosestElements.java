package interview.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
	int val;
	int index;

	public Pair(int val, int index) {
		this.val = val;
		this.index = index;
	}

	public Pair() {
	}
}

public class KClosestElements {

	public static void main(String[] args) {
		int arr[] = { 5, 6, 7, 8, 9, 10 };
		int size = arr.length;
		int k = 3;
		int x = 7;
		System.out.println("::::: K Closest Elements :::::");
		System.out.print("Input : ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		System.out.println("K : " + k);
		System.out.println("Point : " + x);
		kClosestElements(arr, size, k, x);
	}

	private static void kClosestElements(int[] arr, int size, int k, int x) {
		// Create a MAX-HEAP (smaller elements will be at bottom)
		PriorityQueue<Pair> pq = new PriorityQueue<>
				(k + 1, Comparator.comparingInt((Pair p) -> p.val).reversed());
		for (int i = 0; i < size; i++) {
			pq.add(new Pair(Math.abs(x - arr[i]), arr[i]));
			if (pq.size() > k)
				pq.poll();
		}
		System.out.print(k + " Closest Points To " + x + " : { ");
		while (!pq.isEmpty()) {
			System.out.print(pq.poll().index + " ");
		}
		System.out.print("} ");
	}

}
