package interview.BackTracking;

import java.util.HashSet;

public class WordBreakProblem {

	public static void main(String[] args) {
		String str = "microsofthiring"; // input string
		HashSet<String> dict = new HashSet<>();
		String dictArr[] = {"micro" , "soft" , "hi" , "ring" , "hiring" , "microsoft"}; 
		// dictionary creation
		for(int  i = 0 ; i< dictArr.length ; i++){
			dict.add(dictArr[i]);		
		}
		solveWord(str , ""  , dict);
	}
	
	private static void solveWord(String ques , String asf , HashSet<String> dict){
		//================Base Case starts===================
		if(ques.length() == 0){
			System.out.println(asf + " ");
			return;
		}
		//================Base Case ends===================

		
		//check one character at a time by forming strings 
		for(int  i = 0 ; i< ques.length() ; i++){
			String sLeft = ques.substring(0 , i+1); 
			//if set contains the string
			if(dict.contains(sLeft)){
				String sRight = ques.substring(i+1); // generate the left over question 
				solveWord(sRight , asf + sLeft + "  " , dict); // add the string to answer and form the next question with the remainder String
			}
		}
	}

}
