package interview.Stacks;

import java.util.Stack;

public class RemoveAdjacent {
	private static String removeAdjacent(String str){
		if(str.length() == 1) return str;
		Stack<Character> st = new Stack<>();
		String ans = "";
		st.push(str.charAt(0));
		for(int i = 1 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(!st.isEmpty() && ch == st.peek()){
				st.pop();
			}else{
				st.push(ch);
			}
		}
		while(!st.isEmpty())
			ans = st.pop() + ans;
		return ans;
	}
	public static void main(String[] args) {
		String str = "azxxzy";
		System.out.println("Input  : " + str);
		String ans = removeAdjacent(str);
		System.out.println("Output : " + ans);
	}

}
