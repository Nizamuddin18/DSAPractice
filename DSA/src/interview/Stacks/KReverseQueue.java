package interview.Stacks;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class KReverseQueue {
	private static void KreverseQueue(Queue<Integer> queue, int k) {
		int size = queue.size();
		int deltaK = size - k;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i < k ; i++){
			stack.push(queue.poll());
		}
		while(!stack.isEmpty())
			queue.add(stack.pop());
		for(int i = 0 ; i < deltaK ; i++)
			queue.add(queue.poll());
		System.out.println("Output : " + queue);
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		int k = 3;
		System.out.println(":::::: K Reverse of Queue :::::");
		System.out.println("Input  : " + queue);
		System.out.println("k  : " + k);
		KreverseQueue(queue , k);

	}

	

}
