package interview.Heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class KFrequentElements {
	class PairofFrequentElements {
		int key;
		int frequency;

		public PairofFrequentElements(int key, int frequency) {
			this.key = key;
			this.frequency = frequency;
		}

		public PairofFrequentElements() {

		}

		@Override
		public String toString() {
			return "[" + key + "]";
		}
	}

    private static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private int[] findKFrequentElements(int[] arr, int k, int length) {
        // Put all Elements in HashMap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        // Create a Min-Heap of size k+1
        PriorityQueue<PairofFrequentElements> pq = new PriorityQueue<PairofFrequentElements>(k + 1,
                Comparator.comparingInt((PairofFrequentElements p) -> p.frequency));
        // Add elements from HashMap to Min-Heap and
        int j = 0;
        for (Integer i : map.keySet()) {
            pq.add(new PairofFrequentElements(i, map.get(i)));
            j++;
            if (j > k)
                pq.remove();
        }
        int size = pq.size();
        int ret_arr[] = new int[size];
        int index = 0;
        while (!pq.isEmpty()) {
            PairofFrequentElements rem = pq.remove();
            ret_arr[size - index - 1] = rem.key;
            index++;
        }
        return ret_arr;
    }

    public static void main(String[] args) {
        KFrequentElements obj = new KFrequentElements();
        int arr[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(":::::Kth Frequent Elements:::::");
        System.out.print("Input : ");
        display(arr);
        int ret_arr[] = obj.findKFrequentElements(arr, k, arr.length);
        System.out.print("Ouput : ");
        display(ret_arr);
    }
}
