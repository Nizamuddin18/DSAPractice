package interview.Foundation.Stacks;

import java.util.Stack;

public class PreFixToInfixAndPostFix {
	private static String prefixToInfix(String str){
		Stack<String> infix = new Stack<>();
		for(int i = str.length()-1 ; i >= 0 ; i--){
			char ch = str.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				String val1 = infix.pop();
				String  val2 = infix.pop();
				String output = "(" + val1 + ch + val2 + ")";
				infix.push(output);
			}else{
				infix.push(ch + "");
			}
		}
		return infix.peek();
	}
	
	private static String preFixToPostFix(String str){
		Stack<String> postfix = new Stack<>();
		for(int i = str.length()-1 ; i >= 0 ; i--){
			char ch = str.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				String val1 = postfix.pop();
				String  val2 = postfix.pop();
				String output = val1 + val2 + ch;
				postfix.push(output);
			}else{
				postfix.push(ch + "");
			}
		}
		return postfix.peek();
	}
	
	public static void main(String[] args) {
		String prefix = "-+2/*6483";
		String infix = prefixToInfix(prefix);
		String postfix = preFixToPostFix(prefix);
		System.out.println("Prefix Expression	:	" + prefix);
		System.out.println("Infix Expression	:	" + infix);
		System.out.println("PostFix Expression	:	" + postfix);
	}
}
