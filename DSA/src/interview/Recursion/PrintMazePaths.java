package interview.Recursion;
import java.util.*;
public class PrintMazePaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Destination Row : ");
		int drow = sc.nextInt();
		System.out.println("Enter Destination Column : ");
		int dcolumn = sc.nextInt();
		printMazePaths(1 , 1 , drow , dcolumn , "");

	}
	
	private static void printMazePaths(int sc , int sr , int drow , int dcolumn , String psf){
		if(sr == drow && sc == dcolumn){
			System.out.print(psf + " ");
			return;
		}
		if(sc < dcolumn)
			printMazePaths(sc+1 , sr , drow , dcolumn , "h" + psf);
		if (sr < drow)
			printMazePaths(sc , sr+1 , drow , dcolumn , "v" + psf);
	}

}
