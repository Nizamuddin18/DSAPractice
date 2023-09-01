package interview.Recursion;

import java.util.Scanner;
public class PrintMazePaths {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		if(sr == dr && sc == dc){
			System.out.println(psf);
			return;
		}
		// horizontal movement
		if (sc < dc) {
			printMazePaths(sr, sc + 1, dr, dc, psf + "h");
		}

		// vertical movement
		if (sr < dr) {
			printMazePaths(sr + 1, sc, dr, dc, psf + "v");
		}
	}
	 public static void main(String[] args) throws Exception {
         Scanner sc  = new Scanner(System.in);
         System.out.println("Enter destination Row : ");
         int n = sc.nextInt(); // rows
         System.out.println("Enter destination Column : ");
         int m = sc.nextInt(); // cols
         printMazePaths(0 , 0 , n-1 , m-1 , "");
	    }
}
