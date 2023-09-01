package interview.Stacks;

import java.util.Stack;

public class PreFixEvaluation {
	private static int evaluatePreFix(String str){
		Stack<Integer> vstack = new Stack<>();
		for(int i = str.length()-1 ; i >= 0 ; i--){
			char ch = str.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				int val1 = vstack.pop();
				int val2 = vstack.pop();
				int output = operations(val1 , val2 , ch);
				vstack.push(output);
			}else{
				vstack.push(ch - '0');
			}
		}
		return vstack.peek();
	}
	
	private static int operations(int v1 , int v2 , char op){
		int ret = 0;
		if(op == '+')
			ret = v1 + v2;
		else if(op == '-')
			ret = v1 - v2;
		else if(op == '*')
			ret = v1 * v2;
		else if(op == '/')
			ret = v1 / v2;
		return ret;
	}

	public static void main(String[] args) {
		String str = "-+2/*6483";
		int ans = evaluatePreFix(str);
		System.out.println("PreFix Expression : " + str);
		System.out.println("Value of PostFix :" + ans);
	}

}
