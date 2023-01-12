package interview.BackTracking;

public class Sudoku {
	
	private static void sudokuSolve(int [][]board , int row , int col ){
		//================Base Case starts===================
		if(row == board.length){
			display(board);
			return;
		}
		//================Base Case ends===================
		int ni = 0;
		int nj = 0;
		if(col == board[0].length -1){	// if this is the last cell for that particular row
			ni = row + 1; 				// if all the columns for that particular row is checked, update the row by 1 
			nj = 0; 					// make col again 0 for new row
		}else{							// if more cells are present for that particular row
			ni = row;					// row remains same
			nj = col + 1;				// update column by 1
		}
		//if the cell contains a non zero number just move to next row, column
		if(board[row][col] != 0)
			sudokuSolve(board , ni , nj);
		//if the cell contains a zero
		else{
			for(int po = 1 ; po <= 9 ; po++){				 	//check for all the possible options ranging from 1...9
				if(isValid(board , row , col , po) == true){ 	// if the option is valid
					board[row][col] = po; 						// update the cell to that particular option
					sudokuSolve(board , ni , nj); 				// next recursive call
					board[row][col] = 0; 					
					// if in future because of this option other option cannot be placed with rest of the row,column,submatrix -->  then backtrack
				}
			}
		}
	}
	
	private static boolean isValid(int[][] board, int row, int col, int val) {
		//check if the option is present in that particular horizontal row
		for(int c = 0 ; c < board[0].length ; c++){
			if(board[row][c] == val)
				return false;
		}
		//check if the option is present in that particular vertical column
		for(int r = 0 ; r < board.length ; r++){
			if(board[r][col] == val)
				return false;
		}
		//check if the option is present in that particular submatrix
		int submi = (row / 3) * 3;
		int submj = (col / 3) * 3;
		for(int i = 0 ; i < 3 ; i++){
			for(int  j = 0; j < 3 ; j++){
				if(board[submi + i][submj + j] == val)
					return false;
			}
		}
		return true;
	}
	
	private static void display(int[][] board) {
		for(int  i = 0 ; i< board.length ; i++){
			for(int  j = 0; j< board[0].length ; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int board[][] = 	{
							{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         			{5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         			{0, 8, 7, 0, 0, 0, 0, 0, 0}, 
		         			{0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         			{9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         			{0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         			{1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         			{0, 0, 0, 0, 0, 0, 0, 7, 4}, 	
		         			{0, 0, 5, 2, 0, 6, 3, 0, 0} 
		         			};
		
		sudokuSolve(board , 0 , 0);
	}
	
}
