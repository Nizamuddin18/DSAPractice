package interview.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPermutations {
	private static ArrayList<String> getPermutation(String str){
		if(str.length() == 0){
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		
		ArrayList<String> mres = new ArrayList<String>();
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(0);
			String firstPart = str.substring(0 , i);
			String lastPart = str.substring(i+1);
			String roq = firstPart + lastPart;
			ArrayList<String> res = getPermutation(roq);
			for(String s : res)
				mres.add(ch + s);
		}
		return mres;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String str = sc.nextLine();
		System.out.println(getPermutation(str));

	}

}
