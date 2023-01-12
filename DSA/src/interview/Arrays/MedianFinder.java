package interview.Arrays;
import java.util.*;
/*295. Find Median from Data Stream*/
public class MedianFinder {
	PriorityQueue<Integer> left;
	PriorityQueue<Integer> right;

	public MedianFinder() {
		left = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
		right = new PriorityQueue<>(); // Min Heap
	}

	public void addNum(int num) {
		if(right.size() > 0 && right.peek() < num)
			right.add(num);
		else 
			left.add(num);
		
		if(left.size() - right.size() == 2)
			right.add(left.remove());
		else if(right.size() - left.size() == 2)
			left.add(right.remove());
	}

	public double findMedian() {
		if(left.size() == right.size()){
			int lp = left.peek();
			int rp = right.peek();
			double median = (double)(lp + rp)/2;
			return median;
		}else if(left.size() > right.size())
    		return (double)left.peek();
    	else 
    		return (double)right.peek();
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);    // arr = [1]
		medianFinder.addNum(2);    // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3);    // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian()); // return 2.0
	}

}
