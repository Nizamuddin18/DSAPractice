package interview.Foundation.Stacks;

import java.util.Stack;

public class StackToQueue1 {
	Stack<Integer> mainS;
	Stack<Integer> helperS;

	StackToQueue1() {
		mainS = new Stack<>();
		helperS = new Stack<>();
	}

	int size() {
		return mainS.size();
	}

	void add(int val) {
		mainS.push(val);
	}

	int remove() {
		int topVal;
		if (mainS.size() == 0) {
			System.out.println("Queue underflow");
			return -1;
		} else {
			while (mainS.size() > 1) {
				int val = mainS.pop();
				helperS.push(val);
			}
			topVal = mainS.pop();
			while (helperS.size() > 0) {
				mainS.push(helperS.pop());
			}
		}
		return topVal;
	}

	int peek() {
		int topVal;
		if (mainS.size() == 0) {
			System.out.println("Queue underflow");
			return -1;
		} else {
			while (mainS.size() > 1) {
				int val = mainS.pop();
				helperS.push(val);
			}
			topVal = mainS.pop();
			helperS.push(topVal);
			while (helperS.size() > 0) {
				mainS.push(helperS.pop());
			}
		}
		return topVal;
	}

	public static void main(String[] args) {
		System.out.println("Stack To Queue Adapter (Add Efficient) : ");
		StackToQueue1 queue = new StackToQueue1();
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
