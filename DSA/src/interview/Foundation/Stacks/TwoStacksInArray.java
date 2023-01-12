package interview.Foundation.Stacks;

public class TwoStacksInArray {
	int data[];
	int tos1, tos2;

	public TwoStacksInArray(int cap) {
		 data = new int[cap];
         tos1 = -1;
         tos2 = cap;
	}

	public int top1() {
		if (tos1 == -1) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			int val = data[tos1];
			return val;
		}
	}

	public int top2() {
		if (tos2 == data.length) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			int val = data[tos2];
			return val;
		}
	}

	public int size2() {
		return data.length - tos2;
	}

	public int size1() {
		return tos1 + 1;
	}

	public void push1(int val) {
		if (tos1 + 1 < tos2) {
			data[tos1 + 1] = val;
			tos1++;
		} else {
			System.out.println("Stack overflow");
		}
	}

	public void push2(int val) {
		if (tos1 + 1 < tos2) {
			data[tos2 - 1] = val;
			tos2--;
		} else {
			System.out.println("Stack overflow");
		}
	}

	public int pop1() {
		if (tos1 == -1) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			int val = data[tos1];
			tos1--;
			return val;
		}
	}

	public int pop2() {
		if (tos2 == data.length) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			int val = data[tos2];
			tos2++;
			return val;
		}
	}

	public static void main(String[] args) {
		int n = 5;
		TwoStacksInArray stack = new TwoStacksInArray(n);
		System.out.println("push1 10");
		stack.push1(10);
		System.out.println("push1 20");
		stack.push1(20);
		System.out.println("push2 30");
		stack.push2(30);
		System.out.println("push2 40");
		stack.push2(40);
		System.out.println("push2 50");
		stack.push2(50);
		System.out.println("push1 60");
		stack.push1(60);
		System.out.println(stack.top1());
		System.out.println(stack.pop1());
		System.out.println(stack.top1());

		System.out.println(stack.pop1());
		System.out.println(stack.top2());
		System.out.println(stack.top1());

		System.out.println(stack.pop1());
		System.out.println(stack.top2());
		System.out.println(stack.pop2());
	}

}
