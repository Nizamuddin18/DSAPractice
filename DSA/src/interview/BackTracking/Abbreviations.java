package interview.BackTracking;

public class Abbreviations {

	public static void main(String[] args) {
		String str = "pep";
		solution(str , 0 , 0 ,  "");
	}
	
	private static void solution(String str , int count , int pos , String asf){
		//================Base Case starts===================
		if(pos == str.length()){
			if(count == 0)
				System.out.println(asf);
			else
				System.out.println(asf + count);
			return;
		}
		//================Base Case starts===================
		
		if(count > 0)
			solution(str , 0 , pos+1 , asf + count + str.charAt(pos)); // call where the count had a value not equals to 0 and the count needs to be appended to answer so far
		else
			solution(str , 0, pos+1 , asf+str.charAt(pos)); // call where the count is 0
		// when does wants to be included
		solution(str , count + 1 , pos + 1 , asf);
		
	}

}
