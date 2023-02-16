package interview.Foundation.Recursion;

import java.util.Scanner;
public class PrintMazePathWithJumps {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        for(int jump = 1 ; jump + sc <= dc ; jump++)
            printMazePaths(sr , sc + jump , dr , dc , psf + "h" + jump);
            
        for(int jump = 1 ; jump + sr <= dr ; jump++)
            printMazePaths(sr + jump , sc , dr , dc , psf + "v" + jump);
            
        for(int jump = 1 ; jump + sr <= dr && jump + sc <= dc ; jump++)
            printMazePaths(sr + jump , sc + jump , dr , dc , psf + "d" + jump);
    }
	
	public static void pmpj2(int sr , int sc , int dr , int dc , String psf){
		///Base case 
		if(sr == dr && sc == dc){
			System.out.println(psf);
			return;
		}
		// horizontal jump
		for(int jump = 1 ; jump + sc <= dc ; jump++)
			pmpj2(sr , sc + jump , dr , dc , psf + "h" + jump);
		
		// vertical jump
		for(int jump = 1 ; jump + sr <= dr ; jump++)
			pmpj2(sc , sr + jump , dr , dc , psf + "v" + jump);
		
		// diagonal jump
		for(int jump = 1 ; jump + sr <= dr && jump + sc <= dc ; jump++)
			pmpj2(sc + jump , sr + jump , dr , dc , psf + "d" + jump);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Rows : ");
		int n = sc.nextInt();
		System.out.println("Enter Columns");
		int m = sc.nextInt();
		printMazePaths(0, 0, n - 1, m - 1, "");
		/*System.out.println("=================================");
		pmpj2(0 , 0 , n-1 , m-1 , "");*/
	}

}
