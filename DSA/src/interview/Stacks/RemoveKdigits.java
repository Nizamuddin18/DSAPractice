package interview.Stacks;

import java.util.Stack;

public class RemoveKdigits {
    private static String removeKdigits(String str, int k) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            while (!stack.isEmpty() && ch < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        // managing remaining k's
        while (k > 0) {
            stack.pop();
            k--;
        }

        // forming the answer String
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        // managing leading 0's
        while (!ans.isEmpty() && ans.charAt(0) == '0') {
            ans = ans.substring(1, ans.length());
        }
        return ans.length() == 0 ? "0" : ans;
    }

    public static void main(String[] args) {
        System.out.println("::::: Build Lowest Number by Removing k digits from a given number :::::");
        String str = "1432219";
        int k = 3;
        System.out.println("Input Number : " + str);
        System.out.println("K : " + k);
        String ans = removeKdigits(str, k);
        System.out.println("Output : " + ans);

    }

}
