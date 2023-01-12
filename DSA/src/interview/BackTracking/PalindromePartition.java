package interview.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	public static void main(String[] args) {
		String str = "aab";
		System.out.println("Input : " + str);
		List<List<String>> res = new ArrayList<>();
		List<String> subres = new ArrayList<>();
		partition_(str, res, subres);
		System.out.println("Output : " + res);
	}

	private static void partition_(String str, List<List<String>> res, List<String> subres) {
		if (str.length() == 0) {
			res.add(new ArrayList<>(subres));
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String leftSubString = str.substring(0, i + 1);
			if (isPalindrome(leftSubString)) {
				subres.add(leftSubString);
				partition_(str.substring(i + 1), res, subres);
				subres.remove(subres.size() - 1);
			}
		}
	}
	
	public static boolean isPalindrome(String str){
		int li = 0;
		int ri = str.length() - 1;
		while(li < ri){
			if(str.charAt(li)!=str.charAt(ri)){
				return false;
			}
			li++;
			ri--;
		}
		return true;
	}
	
	
	
	
	
	
}
