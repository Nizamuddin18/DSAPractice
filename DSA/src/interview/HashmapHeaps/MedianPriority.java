package interview.HashmapHeaps;
import java.util.Collections;
import java.util.PriorityQueue;
public class MedianPriority {
	public static class MedianPriorityQueue {
	    PriorityQueue<Integer> left;
	    PriorityQueue<Integer> right;

	    public MedianPriorityQueue() {
	      left = new PriorityQueue<>(Collections.reverseOrder()); // max Heap
	      right = new PriorityQueue<>(); //min Heap
	    }

	    public void add(int val) {
	      if(right.size() > 0 && val > right.peek())
	    	  right.add(val);
	      else
	    	  left.add(val);
	      
	      if(left.size() - right.size() == 2)
	    	  right.add(left.remove());
	      else if(right.size() - left.size() == 2)
	    	  left.add(right.remove());
	    }

	    public int remove() {
	    	if(this.size() == 0){
	    		System.out.println("Underflow");
	    		return -1;
	    	}else if(left.size() >= right.size())
	    		return left.remove();
	    	else 
	    		return right.remove();
	    }

	    public int peek() {
	    	if(this.size() == 0){
	    		System.out.println("Underflow");
	    		return -1;
	    	}else if(left.size() >= right.size())
	    		return left.peek();
	    	else 
	    		return right.peek();
	    }

	    public int size() {
	      return left.size() + right.size();
	    }
	    
	  }
	
	public static void main(String[] args) {
		MedianPriorityQueue median = new MedianPriorityQueue();
		median.add(10);
		median.add(20);
		median.add(30);
		median.add(40);
		System.out.println(median.peek());
		median.add(50);
		System.out.println(median.peek());
		System.out.println(median.remove());
		System.out.println(median.peek());
		System.out.println(median.remove());
		System.out.println(median.peek());
		System.out.println(median.remove());
		System.out.println(median.peek());
		System.out.println(median.remove());
		System.out.println(median.peek());
	}

}
