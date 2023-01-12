package interview.Hackerrank;
import java.util.*;
public class Pep_N_Queens {

	public static void main(String[] args) {
		int n = 4;
		List<List<String>> res = solveNQueens(n);
		if(res.size() == 0){
			System.out.println("No solution!");
		}else{
			System.out.println(res);
		}
	}

	private static List<List<String>> solveNQueens(int n) {
		char [][] board = generateBoard(n); //board generated
		List<List<String>> res = new ArrayList<>(); //List created	
		placeQueens(board , 0 , res);
		return res;
	}
	
	private static void placeQueens(char board[][] , int row, List<List<String>> res){
		//================Base Case starts===================
		if(row == board.length){
			ArrayList<String> al = new ArrayList<>();
			for (int rowNo = 0; rowNo < row; rowNo++) {
                char[] temp = board[rowNo];
                String s = new String(temp);
                al.add(s);
            }
			res.add(al);
			return;
		}
		//================Base Case ends===================
		
		
		for(int  col = 0; col < board[0].length ; col++){ // for each col for every row
			if(isValid(board , row , col) == true){ // check whether the position is valid
				board[row][col] = 'Q'; // place the queen 
				
				/* call for the next row and if the queen can be placed 
				in any cell at next row.If no Queen can be placed at next row then backtrack*/
				placeQueens(board , row + 1 , res); 
				
				board[row][col] = '.'; // remove the queen
			}	
		}
	}
		
	private static boolean isValid(char board[][] , int row , int col){
			//checks if any queen is placed vertically on top of the position
			for(int  i = row-1 , j = col ; i >= 0 ; i--){
				if(board[i][j] == 'Q')
					return false;
			}
			//checks if any queen is placed on left top diagonal of the position
			for(int i = row-1 , j = col-1; i>=0 && j >= 0 ; i--,j--){
				if(board[i][j] == 'Q')
					return false;
			}
			//checks if any queen is placed on right top diagonal of the position
			for(int i = row-1 , j = col + 1; i >= 0 && j < board.length ; i-- , j++){
				if(board[i][j] == 'Q')
					return false;
			}
			return true;
		}

	private static char[][] generateBoard(int n) {
		char board[][] = new char[n][n];
		for(int i = 0 ; i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				board[i][j] = '.';
			}
		}
		return board;
	}

}
