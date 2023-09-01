package interview.Stacks;

public class CustomQueue {
	int[] data;
	int front;
	int size;

	public CustomQueue(int cap) {
		data = new int[cap];
		front = 0;
		size = 0;
	}

	int size() {
		return this.size;
	}

	void display() {
		for (int i = 0; i < this.size; i++) {
			int indx = (i + front) % data.length;
			System.out.print(data[indx] + " ");
		}
		System.out.println();
	}

	void add(int val) {
		if (this.size == data.length) {
			System.out.println("Queue overflow");
			return;
		}

		int indx = (this.front + this.size) % data.length;
		data[indx] = val;
		this.size++;
	}

	int remove() {
		if (this.size == 0) {
			System.out.println("Queue underflow");
			return -1;
		}
		int val = data[front];
		this.front = (this.front + 1) % data.length;
		this.size--;
		return val;
	}

	int peek() {
		if (this.size == 0) {
			System.out.println("Queue underflow");
			return -1;
		}
		return data[this.front];
	}

	public static void main(String[] args) {
		CustomQueue queue = new CustomQueue(5);
		// add 10
		queue.add(10);
		queue.display();
		// add 20
		queue.add(20);
		queue.display();
		// add 30
		queue.add(30);
		queue.display();
		// add 40
		queue.add(40);
		queue.display();
		// add 50
		queue.add(50);
		queue.display();
		// add 60
		queue.add(60);
		queue.display();
		queue.peek();
		queue.remove();
		queue.display();
		queue.peek();
		queue.remove();
		queue.display();
		queue.peek();
		queue.remove();
		queue.display();
		queue.peek();
		queue.remove();
		queue.display();
		queue.peek();
		queue.remove();
		queue.display();
		queue.peek();
		queue.remove();
	}

}
