package interview.BackTracking;

public class QueensPermutation2D {
	public static void queensPermutations(int qpsf, int tq, int[][] chess){
		//Base case 
		if(qpsf == tq){
			for(int i = 0 ; i < chess.length ; i++){
				for(int j = 0 ; j < chess[0].length ; j++){
					if(chess[i][j] != 0){
						System.out.print("q" + chess[i][j] + "\t");
					}else
						System.out.print("-\t");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int i = 0 ; i < chess.length ; i++){
			for(int j = 0 ; j < chess[0].length ; j++){
				if(chess[i][j] == 0){
					chess[i][j] = qpsf + 1;
					queensPermutations(qpsf + 1 , tq , chess);
					chess[i][j] = 0;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int n = 2;
		int[][] chess = new int[n][n];
		queensPermutations(0, n, chess);
	}
}
