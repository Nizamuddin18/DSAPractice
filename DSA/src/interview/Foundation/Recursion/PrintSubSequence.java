package interview.Foundation.Recursion;

import java.util.Scanner;

public class PrintSubSequence {
	public static void printSS(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String roq = str.substring(1);
		printSS(roq, ans + ch);
		printSS(roq, ans + "");
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		printSS(str, "");
	}
}
