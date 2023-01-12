package interview.Foundation.Stacks;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstSecondHalfQueue {

	private static void interleaveQueue(Queue<Integer> queue, Stack<Integer> stack, int size) {
		int halfSize = size / 2;
		for(int i = 0 ; i < halfSize ; i++){
			stack.push(queue.poll());
		}
		while(!stack.isEmpty()){
			queue.add(stack.pop());
		}
		for(int i = 0 ; i < halfSize ; i++){
			queue.add(queue.poll());
		}
		for(int i = 0 ; i < halfSize ; i++){
			stack.push(queue.poll());
		}
		while(!stack.isEmpty()){
			queue.add(stack.peek());
			stack.pop();
			queue.add(queue.poll());
		}
		System.out.println("Output : " + queue);
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);
		queue.add(15);
		queue.add(16);
		queue.add(17);
		queue.add(18);
		queue.add(19);
		queue.add(20);
		System.out.println(":::::: Interleave Queue :::::");
		Stack<Integer> stack = new Stack<>();
		int size  = queue.size();
		System.out.println("Input  : " + queue);
		interleaveQueue(queue , stack , size);
	}

}
