package interview.Recursion;
import java.util.*;

public class PrintStairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Stairs Count : ");
		int n = sc.nextInt();
		printStairs(n , "");

	}
	
	private static void printStairs(int n , String psf){
		if(n == 0){
			System.out.print(psf + " , ");
			return;
		}else if(n < 0){
			return;
		}
		printStairs(n-1, 1 + psf);
		printStairs(n-2, 2 + psf);
		printStairs(n-3, 3 + psf);
	}

}
