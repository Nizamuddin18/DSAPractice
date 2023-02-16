package interview.Recursion;

import java.util.ArrayList;
import java.util.Scanner;
public class GetSubSequence {

	public static void main(String[] args) {
		System.out.println("Enter String : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<String> res = getSubSequence(str);
		System.out.println(res);

	}
	
	private static ArrayList<String> getSubSequence(String str){
		if(str.length() == 0){
			ArrayList<String> baseCase = new ArrayList<>();
			baseCase.add("");
			return baseCase;
		}
		char ch = str.charAt(0);
		String restOfString = str.substring(1);
		ArrayList<String> recursionRes = getSubSequence(restOfString);
		ArrayList<String> myRes = new ArrayList<>();
		
		for(String rres : recursionRes){
			myRes.add(ch + rres);
			myRes.add("" + rres);
		}
		return myRes;
	}

}
