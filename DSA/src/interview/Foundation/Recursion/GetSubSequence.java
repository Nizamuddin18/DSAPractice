package interview.Foundation.Recursion;

import java.util.ArrayList;
import java.util.Scanner;
public class GetSubSequence {
	private static ArrayList<String> getSS(String str){
		if(str.length() == 0){
			ArrayList<String> baseres = new ArrayList<>();
			baseres.add("");
			return baseres;
		}
		char ques = str.charAt(0);
		String roq = str.substring(1);
		ArrayList<String> recres = getSS(roq);
		ArrayList<String> mres = new ArrayList<String>();
		for(String s : recres){
			mres.add(""+ s);
		}
		for(String s : recres){
			mres.add(ques + s);
		}
		return mres;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "123";//sc.nextLine();
		System.out.println(getSS(str));
	}

}
