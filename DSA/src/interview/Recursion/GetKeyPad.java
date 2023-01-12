package interview.Recursion;
import java.util.*;
public class GetKeyPad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String str = sc.next();
		ArrayList<String> res = getKeyPad(str);
		System.out.println(res);
	}

	static String[] codes = {".;" , "abc", "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};

	private static ArrayList<String> getKeyPad(String str){
		if(str.length() == 0){
			ArrayList<String> baseCase = new ArrayList<>();
			baseCase.add("");
			return baseCase;
		}
		char ch = str.charAt(0);
		Integer index = Integer.parseInt(String.valueOf(ch));
		String restOfString = str.substring(1);
		ArrayList<String> recursionRes = getKeyPad(restOfString);
		ArrayList<String> myRes = new ArrayList<>();
		String codeForCh = codes[index];
		for(int  i = 0;i < codeForCh.length() ; i++){
			char specChar = codeForCh.charAt(i);
			for(String rres : recursionRes){
				myRes.add(specChar + rres);
			}
		}
		
		
		return myRes;
	}
}
