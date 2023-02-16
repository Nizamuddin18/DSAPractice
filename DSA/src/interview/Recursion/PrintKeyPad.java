package interview.Recursion;

import java.util.Scanner;
public class PrintKeyPad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String str = sc.next();
		System.out.print("[ ");
		printKeyPad(str , "");
		System.out.print(" ]");

	}
	static String[] codes = {".;" , "abc", "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};
	
	private static void printKeyPad(String ques, String ans) {
		if(ques.length() == 0){
			System.out.print(ans + ", ");
			return;
		}
		char ch = ques.charAt(0);
		int idx = Integer.parseInt(String.valueOf(ch)); 
		String resOfString = ques.substring(1);
		String codeForCh = codes[idx];
		for(int i = 0; i< codeForCh.length() ; i++){
			char specChar = codeForCh.charAt(i);
			printKeyPad(resOfString , ans + specChar);
		}
		
		
	}

}
