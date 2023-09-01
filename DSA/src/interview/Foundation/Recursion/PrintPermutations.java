package interview.Recursion;

import java.util.ArrayList;
import java.util.Scanner;
public class PrintPermutations {
	private static void printPermutations(String ques, String ansf) {
		if(ques.length() == 0){
			System.out.println(ansf);
			return;
		}
		for(int i = 0 ; i < ques.length() ; i++){
			char ch = ques.charAt(i);
			String firstPart = ques.substring(0,i);
			String lastPart = ques.substring(i+1);
			String roq = firstPart + lastPart;
			printPermutations(roq ,  ansf + ch);
		}	
	}
	
	private static ArrayList<String> getPermutations(String ques){
		if(ques.length() == 0){
			ArrayList<String> bres = new ArrayList<>();
			bres.add("");
			return bres;
		}
		ArrayList<String> mres = new ArrayList<>();
		for(int i = 0 ; i < ques.length() ; i++){
			String ch = ques.charAt(i) + "";
			String firstPart = ques.substring(0 , i);
			String lastPart = ques.substring(i+1);
			String roq = firstPart + lastPart;
			ArrayList<String> rres = getPermutations(roq);
			for(String s : rres){
				mres.add(ch + s);
			}
		}
		return mres;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String ques = sc.nextLine();
		printPermutations(ques , "");
		ArrayList<String> list = getPermutations(ques);
		System.out.println(list);
	}
}
