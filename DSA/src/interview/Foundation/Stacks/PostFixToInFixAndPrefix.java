package interview.Foundation.Stacks;

import java.util.Stack;

public class PostFixToInFixAndPrefix {
	private static String postfixToInfix(String str){
		Stack<String> infix = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				String val2 = infix.pop();
				String  val1 = infix.pop();
				String output = "(" + val1 + ch + val2 + ")";
				infix.push(output);
			}else{
				infix.push("" + ch);
			}
		}
		return infix.peek();
	}
	
	private static String postFixToPreFix(String str){
		Stack<String> prefix = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
				String val2 = prefix.pop();
				String  val1 = prefix.pop();
				String output = ch + val1 + val2;
				prefix.push(output);
			}else{
				prefix.push("" + ch);
			}
		}
		return prefix.peek();
	}
	
	public static void main(String[] args) {
		String postfix = "264*8/+3-";
		String infix = postfixToInfix(postfix);
		String prefix = postFixToPreFix(postfix);
		System.out.println("PostFix Expression	:	" + postfix);
		System.out.println("Infix Expression	:	" + infix);
		System.out.println("Prefix Expression	:	" + prefix);
	}

}
