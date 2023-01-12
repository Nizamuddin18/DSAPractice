package interview.Foundation.Stacks;

import java.util.Stack;

public class MinStack1 {
	Stack<Integer> st = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	
	public int getSize(){
		return st.size();
	}
	
	public int top(){
		return st.peek();
	}
	
	public int pop(){
		int popVal;
		if(st.size() == 0){
			System.out.println("Stack UnderFlow");
			return -1;
		}else{
			int peekVal = st.peek();
			if(peekVal == minStack.peek()){
				minStack.pop();
			}
			popVal = st.pop();	
		}
		return popVal;
	}
	
	public void push(int val){
		if(st.isEmpty() && minStack.isEmpty()){
			minStack.push(val);
		}else{
			if(minStack.peek() >= val)
				minStack.push(val);
		}
		st.push(val);
	}
	
	public int getMin(){
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack1 stack = new MinStack1();
		stack.push(10);
		stack.push(2);
		stack.push(5);
		stack.push(8);
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.push(2);
		stack.push(11);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		stack.push(4);
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
	}

}
