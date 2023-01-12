package interview.Strings;

public class PrintAllPalindromicSS {
	public static void solution(String str){
	    
	    for(int i = 0 ; i < str.length() ; i++){
	        String str1 = "";
	        for(int j = i ; j < str.length() ; j++){
	            char ch = str.charAt(j);
	            str1 = str1 + ch;
	            if(isStringPalindrome(str1))
	                System.out.println(str1);
	        }
	    }
	}
	
	private static boolean isStringPalindrome(String str){
	    String rev = "";
	    for(int i = 0 ; i < str.length() ; i++){
	    	char ch = str.charAt(i);
	        rev = ch + rev;
	    }
	    if(rev.equals(str))
	        return true;
	    return false;
	}
	public static void main(String[] args) {
		String str = "abcc";
		solution(str);

	}

}
