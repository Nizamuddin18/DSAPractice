package interview.Foundation.Stacks;

import java.util.Stack;

public class SortStackUsingRecursion {
	private static void sort(Stack<Integer> st)
	{
		if(st.size() == 1)
			return;
		int temp = st.pop();
		sort(st);
		insert(st,temp);
	}
	
	private static void insert(Stack<Integer> st , int temp){
		if(st.size() == 0 || st.peek() <= temp){
			st.push(temp);
			return;
		}
		int val = st.pop();
		insert(st,temp);
		st.push(val);
	}
	public static void main(String[] args) {
		System.out.println("::::: Sort a Stack Using Recursion :::::");
		Stack<Integer> st = new Stack<>();
		st.push(5);
		st.push(1);
		st.push(6);
		st.push(2);
		st.push(4);
		System.out.println("Stack before Sorting : " + st);
		sort(st);
		System.out.println("Stack after  Sorting : " + st);
	}

}
