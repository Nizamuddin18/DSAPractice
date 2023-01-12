package interview.Recursion;
/*
 *In case of Recursion Row is the level Order which is passed as a parameter and
 Columns are the options for each row which needs to be traced 
 */
public class NQueens {

	public static void main(String[] args) {
		int board[][] = new int[4][4];
		placeQueens(board , 0  , ""); // source is 0,0

	}
	
	private static void placeQueens(int board[][] , int row , String asf){
		//================Base Case starts===================
		if(row == board.length){
			System.out.println(asf + " ");
			return;
		}
		//================Base Case ends===================
		
		
		for(int  col = 0; col < board[0].length ; col++){ // for each col for every row
			if(isValid(board , row , col) == true){ // check whether the position is valid
				board[row][col] = 1; // place the queen 
				
				placeQueens(board , row + 1 , asf + "(" + row + " - " + col + "), "); /* call for the next row and if the queen can be placed 
				in any cell at next row.If no Queen can be placed at next row then backtrack*/
				board[row][col] = 0; // remove the queen
			}
			
		}
		
	}
	
	private static boolean isValid(int board[][] , int row , int col){
		//checks if any queen is placed vertically on top of the position
		for(int  i = row-1 , j = col ; i >= 0 ; i--){
			if(board[i][j] == 1)
				return false;
		}
		//checks if any queen is placed on left top diagonal of the position
		for(int i = row-1 , j = col-1; i>=0 && j >= 0 ; i--,j--){
			if(board[i][j] == 1)
				return false;
		}
		//checks if any queen is placed on right top diagonal of the position
		for(int i = row-1 , j = col + 1; i >= 0 && j < board.length ; i-- , j++){
			if(board[i][j] == 1)
				return false;
		}
		return true;
	}

}
