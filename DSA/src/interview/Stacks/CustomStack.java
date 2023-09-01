package interview.Stacks;

public class CustomStack {
	int[] data;
	int tos;

	CustomStack(int cap) {
		data = new int[cap];
		tos = -1;
	}

	int size() {
		return tos + 1;
	}

	void display() {
		for (int i = tos; i >= 0; i--)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	void push(int val) {
		if (tos == data.length - 1) {
			System.out.println("Stack overflow");
		} else {
			data[++tos] = val;
		}
	}

	int pop() {
		int val;
		if (tos == -1) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			val = data[tos];
			tos--;
		}
		return val;
	}

	int top() {
		int val;
		if (tos == -1) {
			System.out.println("Stack underflow");
			return -1;
		} else {
			val = data[tos];
		}
		return val;
	}

	public static void main(String[] args) {
		CustomStack st = new CustomStack(5);
		//push 10
		st.push(10);
		st.display();
		//push 20
		st.push(20);
		st.display();
		//push 30
		st.push(30);
		st.display();
		//push 40
		st.push(40);
		st.display();
		//push 50
		st.push(50);
		st.display();
		//push 60
		st.push(60);
		st.display();
		st.top();
		st.pop();
		st.display();
		st.top();
		st.pop();
		st.display();
		st.top();
		st.pop();
		st.display();
		st.top();
		st.pop();
		st.display();
		st.top();
		st.pop();
		st.display();
		st.top();
		st.pop();
	}
}
