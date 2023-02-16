package interview.Recursion;

import java.util.Scanner;
public class PrintPermutations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String str = sc.next();
		printPermutations(str , "");

	}
	
	private static void printPermutations(String str , String ans){
		if(str.length() == 0){
			System.out.print(ans + " ");
			return;
		}
		for(int i = 0; i< str.length() ; i++){
			char ch = str.charAt(i);
			String qlPart = str.substring(0,i);
			String qrPart = str.substring(i+1);
			String ros = qlPart + qrPart;
			printPermutations(ros , ch + ans);
		}
		
	}

}
