package interview.Stacks;

import java.util.Stack;

public class ReverseStackUsingRecursion {

	private static void reverse(Stack<Integer> st){
		if(st.size() == 1)
			return;
		int temp = st.pop();
		reverse(st);
		insertatBottom(st,temp);
	}
	private static void insertatBottom(Stack<Integer> st , int temp){
		if(st.isEmpty())
			st.push(temp);
		else{
			int val = st.pop();
			insertatBottom(st,temp);
			st.push(val);
		}
	}
	public static void main(String[] args) {
		System.out.println("::::: Reverse a Stack Using Recursion :::::");
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(3);
		st.push(2);
		st.push(4);
		st.push(1);
		System.out.println("Stack before Reverse : " + st);
		reverse(st);
		System.out.println("Stack after  Reverse : " + st);
	}

}
