package interview.Foundation.Stacks;

import java.util.ArrayDeque;
import java.util.Queue;

/*Implement Queue to Stack Adapter pop efficient*/
public class QueueToStack1 {
	Queue<Integer> mainQ = new ArrayDeque<>();
	Queue<Integer> helperQ = new ArrayDeque<>();
	
	public int getSize(){
		return mainQ.size();
	}
	
	public int pop(){
		return mainQ.remove();
	}
	public int top(){
		return mainQ.peek();
	}
	public void push(int val){
		while(mainQ.size() > 0){
			helperQ.add(mainQ.remove());
		}
		mainQ.add(val);
		while(helperQ.size() > 0){
			mainQ.add(helperQ.remove());
		}
	}
	public static void main(String[] args) {
		QueueToStack1 stack = new QueueToStack1();
		System.out.println("Queue to Stack Adapter (Pop Efficient) : ");
		stack.push(10);
		stack.push(20);
		stack.push(5);
		stack.push(8);
		stack.push(2);
		stack.push(4);
		stack.push(11);
		System.out.println("Push 10");
		System.out.println("Push 20");
		System.out.println("Push 5");
		System.out.println("Push 8");
		System.out.println("Push 2");
		System.out.println("Push 4");
		System.out.println("Push 11");
		System.out.println("Top : " + stack.top());
		System.out.println("Pop : " + stack.pop());
		System.out.println("Print Stack : " + stack.mainQ);
		System.out.println("Top : " + stack.top());
	}

}
