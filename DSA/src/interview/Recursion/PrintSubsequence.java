package interview.Recursion;

import java.util.Scanner;

public class PrintSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sc.next();
		System.out.print("[ ");
		printSubsequence(str , ""); // str is the question and "" is the answer
		System.out.print("]");
	}

	private static void printSubsequence(String str, String ans) {
		if(str.length() == 0){
			System.out.print(ans + " , ");
			return;
		}
		char ch = str.charAt(0);
		String resOfString = str.substring(1);
		printSubsequence(resOfString , ans + ch);
		printSubsequence(resOfString , ans + "");
	}

}
