package interview.Stacks;

import java.util.Stack;

public class MinStack2 {
    Stack<Integer> stack = new Stack<>();
    int min;

    public int getSize() {
        return stack.size();
    }

    public int top() {
        int topVal;
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            topVal = stack.peek();
            if (topVal < min) {
                topVal = min;
            }
        }
        return topVal;
    }

    public int pop() {
        int popVal;
        if (stack.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            popVal = stack.pop();
            if (popVal < min) {
                int orirginalVal = min;
                min = 2 * min - popVal;
                popVal = orirginalVal;
            }
        }
        return popVal;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else {
            if (val <= min) {
                stack.push(val + val - min);
                min = val;
            } else {
                stack.push(val);
            }
        }
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack2 stack = new MinStack2();
        stack.push(10);
        stack.push(20);
        stack.push(5);
        stack.push(8);
        stack.push(2);
        stack.push(4);
        stack.push(11);
        System.out.println("Top : " + stack.top());
        ;
        System.out.println("Min : " + stack.getMin());
        System.out.println("Pop : " + stack.pop());
        System.out.println("Min : " + stack.getMin());
        System.out.println("Pop : " + stack.pop());
        System.out.println("Top : " + stack.top());
        System.out.println("Min : " + stack.getMin());

    }

}
