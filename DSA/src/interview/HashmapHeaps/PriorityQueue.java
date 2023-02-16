package interview.HashmapHeaps;

import java.util.ArrayList;

public class PriorityQueue {
	ArrayList<Integer> data;
	
	public PriorityQueue() {
		data = new ArrayList<Integer>();
	}
	
	private void upHeapify(int i) {
		if(i==0)
			return;
		int pi = (i-1)/2;
		if(data.get(i) < data.get(pi)){
			swap(i , pi);
			upHeapify(pi);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}
	
	private void add(int val){
		data.add(val);
		upHeapify(data.size() - 1);
	}
	
	private int remove(){
		if(this.size() == 0){
			System.out.println("Underflow");
			return -1;
		}
		swap(0, data.size() -1);
		int val = data.remove(data.size() - 1);
		downHeapify(0);
		return val;
			
	}
	
	private int peek(){
		if(this.size() == 0){
			System.out.println("Underflow");
			return -1;
		}
		
		return data.get(0);
	}
	
	private int size(){
		return (data.size());
	}
	
	private void downHeapify(int pi) {
		int min = pi;		//Parent Index
		int li = 2*pi + 1;	//Left Child Index
		int ri = 2*pi + 2;	//Right Child Index
		if(li < data.size() && data.get(li) < data.get(min))
			min = li;
		if(ri < data.size() && data.get(ri) < data.get(min))
			min = ri;
		
		if(min != pi){
			swap(pi, min);	
			downHeapify(min);
		}	
	}

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.add(10);
		pq.add(20);
		pq.add(30);
		pq.add(40);
		System.out.println(pq.peek());
		pq.add(50);
		System.out.println(pq.peek());
		System.out.println(pq.remove());
		System.out.println(pq.peek());
		System.out.println(pq.remove());
		System.out.println(pq.peek());
		System.out.println(pq.remove());
		System.out.println(pq.peek());
		System.out.println(pq.remove());
		System.out.println(pq.peek());
		
	}

}
