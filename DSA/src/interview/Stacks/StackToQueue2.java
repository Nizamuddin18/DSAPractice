package interview.Stacks;

import java.util.Stack;

public class StackToQueue2 {
	Stack<Integer> mainS;
	Stack<Integer> helperS;

	public StackToQueue2() {
		mainS = new Stack<>();
		helperS = new Stack<>();
	}

	int size() {
		return mainS.size();
	}

	void add(int val) {
		while (mainS.size() > 0) {
			helperS.push(mainS.pop());

		}
		mainS.push(val);
		while (helperS.size() > 0) {
			mainS.push(helperS.pop());
		}
	}

	int remove() {
		if (mainS.size() == 0) {
			System.out.println("Queue underflow");
			return -1;
		}
		return mainS.pop();
	}

	int peek() {
		if (mainS.size() == 0) {
			System.out.println("Queue underflow");
			return -1;
		}
		return mainS.peek();
	}

	public static void main(String[] args) {
		System.out.println("Stack To Queue Adapter (Remove Efficient) : ");
		StackToQueue2 queue = new StackToQueue2();
		queue.add(10);
		// System.out.println("add 10");
		queue.add(20);
		// System.out.println("add 20");
		queue.add(30);
		// System.out.println("add 30");
		queue.add(40);
		// System.out.println("add 40");
		queue.add(50);
		// System.out.println("add 50");
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(60);
		// System.out.println("add 60");
		queue.add(70);
		// System.out.println("add 70");
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());

		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());

		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.peek());

		System.out.println(queue.remove());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
	}

}
