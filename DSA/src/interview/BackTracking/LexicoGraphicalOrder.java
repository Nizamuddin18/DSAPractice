package interview.BackTracking;

public class LexicoGraphicalOrder {

	public static void main(String[] args) {
		int  n = 1000;
		//initially loop for all the possible base digits i.e 1..9
		for(int  i = 1 ; i<= 9 ; i++){
			printLexicoGraphical(i , n);
		}
	}
	
	private static void printLexicoGraphical(int i , int n){
		//================Base Case starts===================
		if( i > n){
			return;
		}
		//================Base Case ends===================

		System.out.println(i);//Pre order traversal
		for(int  j = 0 ; j < 10 ; j++){
			printLexicoGraphical(10 * i + j , n);
		}
	}

}
