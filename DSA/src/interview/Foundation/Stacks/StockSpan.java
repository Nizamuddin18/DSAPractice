package interview.Foundation.Stacks;

import java.util.ArrayList;
import java.util.Stack;

class Pair {
	int data;
	int index;

	public Pair(int data, int index) {
		this.data = data;
		this.index = index;
	}
}

public class StockSpan {

	public static void main(String[] args) {
		int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
		Stack<Pair> st = new Stack<Pair>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty()) {
				list.add(-1);
			} else if (!st.isEmpty() && st.peek().data > arr[i]) {
				list.add(st.peek().index);
			} else if (!st.isEmpty() && st.peek().data <= arr[i]) {
				while (!st.isEmpty() && st.peek().data <= arr[i])
					st.pop();
				if (st.isEmpty())
					list.add(-1);
				else
					list.add(st.peek().index);
			}
			Pair pair = new Pair(arr[i], i);
			st.push(pair);
		}
		for (int i = 0; i < list.size(); i++) {
			int val = i - list.get(i);
			System.out.print(val + " ");
		}
	}

}
