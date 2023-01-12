package interview.BackTracking;

public class QueensCombination2D {
	//qpsf - > Queen placed so far
	//tq - > total queen
	
	 public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
		 //Base case
		 if(row == tq){
			 if(qpsf == tq)
				 System.out.print(asf);
			 return;
		 }
		 
		 
		 if(col + 1 < tq){
			 //yes call
			 queensCombinations(qpsf + 1 , tq , row , col + 1 , asf + "q ");
			 //no call
			 queensCombinations(qpsf , tq , row , col + 1 , asf + "- "); 
		 }else{
			 //yes call
			 queensCombinations(qpsf + 1 , tq , row + 1 , 0 , asf + "q \n");
			 //no call
			 queensCombinations(qpsf , tq , row + 1 , 0 , asf + "- \n");
		 }
	 }
	 
	public static void main(String[] args) {
		int n = 2;
		queensCombinations(0 , n , 0 , 0 , "");

	}

}
