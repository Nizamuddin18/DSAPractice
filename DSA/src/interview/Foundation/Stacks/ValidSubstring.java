package interview.Foundation.Stacks;

import java.util.Stack;
/**
 * 
 * @author asus
 * Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', 
 * find out the length of the longest valid(well-formed) parentheses substring.
	NOTE: Length of smallest the valid substring ( ) is 2.
 *
 */
public class ValidSubstring {
	private static int lengthOfValidSubString(String str){
		int count = 0 ;
		Stack<Character> st = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(ch == '(')
				st.push(ch);
			else if(ch == ')'){
				if(st.peek() == '('){
					st.pop();
					count+=2;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		String str = "(()(";
		System.out.println("Input : " + str);
		int ans = lengthOfValidSubString(str);
		System.out.println("Output : " + ans);

	}

}
