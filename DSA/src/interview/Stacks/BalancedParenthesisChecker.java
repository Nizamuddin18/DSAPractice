package interview.Stacks;

import java.util.Stack;

public class BalancedParenthesisChecker {
    private static boolean isValid(String str, Stack<Character> st) {
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                st.push(ch);
            } else {
                switch (ch) {
                    case ')':
                        flag = handleCharacter(st, '(', str);
                        if (flag == false)
                            return false;
                        break;
                    case '}':
                        flag = handleCharacter(st, '{', str);
                        if (flag == false)
                            return false;
                        break;
                    case ']':
                        flag = handleCharacter(st, '[', str);
                        if (flag == false)
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }
        if (!st.isEmpty())
            flag = false;
        return flag;
    }

    private static boolean handleCharacter(Stack<Character> st, char openingChar, String str) {
        boolean flag = true;
        if (st.isEmpty()) {
            flag = false;
        } else if (st.peek() != openingChar) {
            flag = false;
        } else {
            st.pop();
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println("::::: Boolean Valid Balanced Parenthsis Check :::::");
        String str = "{([])}";
        Stack<Character> st = new Stack<>();
        System.out.println("Input String  : " + str);
        boolean ans = isValid(str, st);
        System.out.println("Output : " + ans);

    }

}
