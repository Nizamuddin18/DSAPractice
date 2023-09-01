package interview.Stacks;

import java.util.Stack;

public class InfixEvaluation {
	private static int evaluate(String str){
		Stack<Character> oprt = new Stack<>();
		Stack<Integer> opnd = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(ch == '('){
				oprt.push(ch);
			}else if(ch == ')'){
				while(!oprt.isEmpty() && oprt.peek() != '('){
					char operator = oprt.pop();
					int v2 = opnd.pop();
					int v1 = opnd.pop();
					int output = operations(v1 , v2 , operator);
					opnd.push(output);
				}
				oprt.pop();
			}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				while(!oprt.isEmpty() && oprt.peek() != '(' &&
						preceedence(ch) <= preceedence(oprt.peek())){
					char operator = oprt.pop();
					int v2 = opnd.pop();
					int v1 = opnd.pop();
					int output = operations(v1 , v2 , operator);
					opnd.push(output);
				}
				oprt.push(ch);
			}else{
				if(Character.isDigit(ch)){
					opnd.push(ch - '0');
				}
			}
		}
		while(!oprt.isEmpty()){
			char operator = oprt.pop();
			int v2 = opnd.pop();
			int v1 = opnd.pop();
			int output = operations(v1 , v2 , operator);
			opnd.push(output);
		}
		return opnd.peek();
	}
	
	private static int preceedence(char ch){
		int ret = 0;
		if(ch == '+' || ch == '-')
			ret = 1;
		else if(ch == '*' || ch == '/') 
			ret = 2;
		return ret;
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
		String str = "2+(5-3*6/2)";
		int ans = evaluate(str);
		System.out.println("Infix Expression evaluation :" + ans);
	}
}
