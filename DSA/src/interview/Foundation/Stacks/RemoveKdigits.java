package interview.Foundation.Stacks;

import java.util.Stack;

public class RemoveKdigits {
	private static String removeKdigits(String str , int k){
		Stack<Character> st = new Stack<>();
		String str1 = "";
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			while(!st.isEmpty() && st.peek() > ch && k > 0){
				st.pop();
				k--;
			}
			st.push(ch);
		}
		while(!st.isEmpty())
			str1 = st.pop() + str1;
		if(str1.charAt(0) == '0')
			str1 = str1.substring(1, str1.length());
		return str1;
	}
	public static void main(String[] args) {
		System.out.println("::::: Build Lowest Number by Removing k digits from a given number :::::");
		String str = "121198";
		int k = 2;
		System.out.println("Input Number : " + str);
		System.out.println("K : " + k);
		String ans = removeKdigits(str , k);
		System.out.println("Output : " + ans);

	}

}
