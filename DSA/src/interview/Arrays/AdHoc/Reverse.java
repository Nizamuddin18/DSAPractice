package interview.Arrays.AdHoc;

public class Reverse {
	public String getReverese(String a){
		String b="";
		for(int i=0; i<a.length();i++){
			b = a.charAt(i) + b;
		}
		return b;
	}
}
