package interview.Recursion;

import java.util.Scanner;

public class NqueenDemo {
	
	private static void selectBoxes(int cb , int tb , int bsf , String asf){
		if(cb == tb){
			if(bsf == 2)
				System.out.println("No of Box selected is " + bsf + " with no of ways " +  asf);
			return;
		}
		
		selectBoxes(cb+1 , tb , bsf + 1 , asf + cb + " "); // yes call
		selectBoxes(cb+1 , tb , bsf , asf); // No Call
	}
	
	/*
	 * Select Boxes in 2D Matrix such that after selecting one box no other box is selected 
	 * in same Row
	 *
	 * */
	
	private static void print2dWays(int n , int m , int r , int c , int bsf , String asf){
		if(n == r){
			if(bsf == 2)
				System.out.println(asf);
			return;
		}
		//Check whwther next Column is Valid
		if(c + 1 < m){ //If Valid
			//Yes Call
			print2dWays(n , m , r+1 , 0 , bsf + 1 , asf + "(" + r + "-" + c + ")");
			//No Call
			print2dWays(n , m , r , c+1 , bsf, asf);
		}else{//Invalid 
			// Yes Call 
			print2dWays(n , m , r+1 , 0 , bsf + 1 , asf + "(" + r + "-" + c + ")");
			//No Call
			print2dWays(n , m , r+1 , c , bsf, asf);
		}
	}
	
	private static void print2DWays1(int n , int m , int r , int c , int bsf , String asf){
		if(n == r){
			System.out.println(asf);
			return;
		}
		
		//Yes Call 
		if(c + 1 < m) // Valid Columns
			print2DWays1(n , m , r , c+1 , bsf + 1 , asf + "(" + r + "-" + c + ") ");
		else // Invalid Columns
			print2DWays1(n , m , r + 1 , 0 , bsf + 1 , asf + "(" + r + "-" + c + ") ");
		
		// No Call
		if(c + 1 < m) // Valid Columns
			print2DWays1(n , m , r , c+1 , bsf , asf);
		else
			print2DWays1(n , m , r+1 , 0 , bsf , asf);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 2;//sc.nextInt();
		int m = 2;//sc.nextInt();
		//selectBoxes(0 , 4 , 0 , "");
		
		/*System.out.println("print2DWays1");
		print2DWays1(n , m , 0 , 0 , 0 , "");*/
		
		System.out.println("print2DWays");
		print2dWays(n , m , 0 , 0 , 0 , "");
	}

}
