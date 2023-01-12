package interview.Foundation.Stacks;

import java.util.Stack;

public class DeleteMiddleFromStack {
	private static void deleteMiddle(Stack<Integer> st , int mid){
		if(mid == 1 && !st.isEmpty()){
			st.pop();
			return;
		}
		int pop = st.pop();
		deleteMiddle(st,mid-1);
		st.push(pop);
	}

	public static void main(String[] args) {
		System.out.println("::::: Delete Middle Element from Stack :::::");
		Stack<Integer> st = new Stack<>();
		st.push(6);
		st.push(5);
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		int mid = (int) (Math.floor(st.size()/2) + 1);
		System.out.println("Stack before Deletion : " + st);
		deleteMiddle(st , mid);
		System.out.println("Stack after Deletion  : " + st);

	}

}
