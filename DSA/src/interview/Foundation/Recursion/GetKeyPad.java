package interview.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKeyPad {
	static String[] codes = {".;" , 
			"abc", "def" , "ghi" , 
			"jkl" , "mno" , "pqrs" , 
			"tu" , "vwx" , "yz"};
	private static ArrayList<String> getKeyPad(String str){
		// Base Case
		if(str.length() == 0){
			ArrayList<String> baseres = new ArrayList<>();
			baseres.add("");
			return baseres;
		}
		int index = str.charAt(0) - '0';
		String code = codes[index];
		String restOfQues = str.substring(1);
		ArrayList<String> rres = getKeyPad(restOfQues);
		ArrayList<String> mres = new ArrayList<>();
		for(int i = 0 ; i < code.length() ; i++){
			char ch = code.charAt(i);
			for(String s : rres)
				mres.add(ch + s);
		}
		return mres;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Keypad String : ");
		String str = sc.nextLine();
		System.out.println(getKeyPad(str));
	}

}
