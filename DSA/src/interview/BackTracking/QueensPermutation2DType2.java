package interview.BackTracking;

public class QueensPermutation2DType2 {
	public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, 
											boolean[] queens) {
		// Base Case 
		if(qpsf == tq){
			System.out.print(asf);
			System.out.println();
			return;
		}
		
		//yes call
        for(int q = 0 ; q < tq ; q++){
        	if(queens[q] == false){
        		queens[q] = true;
        		if(col + 1 < tq)
        			queensPermutations(qpsf + 1 , tq , row , col + 1 , asf + "q" + (q+1) + " " , 
        								queens);
        		else
        			queensPermutations(qpsf + 1 , tq , row + 1 , 0 , asf + "q" + (q+1) + " \n" , 
        								queens);
        		queens[q] = false;
        	}
        }
        
        //no call 
        if(col + 1 < tq)
        	queensPermutations(qpsf , tq , row , col + 1 , asf + "-" + " " , 
										queens);
        else
        	queensPermutations(qpsf , tq , row + 1 , 0, asf + "-" + " \n" , 
										queens);	
    }
	
	public static void main(String[] args) {
		int n = 2;
        boolean[] queens = new boolean[n];
        queensPermutations(0, n, 0, 0, "", queens);

	}

}
