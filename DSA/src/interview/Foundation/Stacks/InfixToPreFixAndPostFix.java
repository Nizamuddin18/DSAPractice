package interview.Foundation.Stacks;

import java.util.Stack;

public class InfixToPreFixAndPostFix {
	private static String infixToPrefix(String str){
		Stack<Character> oprt = new Stack<>();
		Stack<String> opnd = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(ch == '('){
				oprt.push(ch);
			}else if(ch == ')'){
				while(!oprt.isEmpty() && oprt.peek() != '('){
					char operator = oprt.pop();
					String v2 = opnd.pop();
					String v1 = opnd.pop();
					String output = operator + v1 + v2;
					opnd.push(output);
				}
				oprt.pop();
			}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				while(!oprt.isEmpty() && oprt.peek() != '(' &&
						preceedence(ch) <= preceedence(oprt.peek())){
					char operator = oprt.pop();
					String v2 = opnd.pop();
					String v1 = opnd.pop();
					String output = operator + v1 + v2;
					opnd.push(output);
				}
				oprt.push(ch);
			}else{
				String s = ch + "";
				opnd.push(s);
			}
		}
		while(!oprt.isEmpty()){
			char operator = oprt.pop();
			String v2 = opnd.pop();
			String v1 = opnd.pop();
			String output = operator + v1 + v2;
			opnd.push(output);
		}
		return opnd.peek();
	}
	
	private static String infixToPostfix(String str){
		Stack<Character> oprt = new Stack<>();
		Stack<String> opnd = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(ch == '('){
				oprt.push(ch);
			}else if(ch == ')'){
				while(!oprt.isEmpty() && oprt.peek() != '('){
					char operator = oprt.pop();
					String v2 = opnd.pop();
					String v1 = opnd.pop();
					String output = v1 + v2 + operator;
					opnd.push(output);
				}
				oprt.pop();
			}else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				while(!oprt.isEmpty() && oprt.peek() != '(' &&
						preceedence(ch) <= preceedence(oprt.peek())){
					char operator = oprt.pop();
					String v2 = opnd.pop();
					String v1 = opnd.pop();
					String output = v1 + v2 + operator;
					opnd.push(output);
				}
				oprt.push(ch);
			}else{
				String s = "" + ch;
				opnd.push(s);
			}
		}
		while(!oprt.isEmpty()){
			char operator = oprt.pop();
			String v2 = opnd.pop();
			String v1 = opnd.pop();
			String output = v1 + v2 + operator;
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

	public static void main(String[] args) {
		String infix = "a*(b-c+d)/e";
		String prefix = infixToPrefix(infix);
		String postfix = infixToPostfix(infix);
		System.out.println("Infix Expression	: " + infix);
		System.out.println("PreFix Expression	: " + prefix);
		System.out.println("PostFix Expression	: " + postfix);

	}

}
