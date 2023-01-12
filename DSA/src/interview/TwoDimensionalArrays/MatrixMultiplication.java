package interview.TwoDimensionalArrays;
import java.util.*;
public class MatrixMultiplication {
	private static void matrixMult(int[][] arr1, int[][] arr2,int n1, int m1, int n2, int m2) {
		int c[][] = new int[arr1.length][arr2[0].length];
		 // Multiply the two marices
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length ; j++) {
            	int val = 0;
                for (int k = 0; k < m1; k++)
                	val += (arr1[i][k] * arr2[k][j]);
                c[i][j] = val;
            }
        }  
        printMatrix(c);	
	}

	private static void printMatrix(int[][] c) {
		for(int i = 0 ; i < c.length ; i++){
			for(int j = 0 ; j < c[i].length ; j++){
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

	private static boolean checkIfMultIsPossible(int n1, int m1, int n2, int m2) {
		if(m1!=n2){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n1 and m1 : ");
		int n1 = sc.nextInt(); // representing the number of rows of 1st matrix.
		int m1 = sc.nextInt(); //  representing the number of columns of 1st matrix.
		int arr1[][] = new int[n1][m1];
		System.out.println("Enter arr1 elements : ");
		for(int i = 0 ; i < n1 ; i++){
			for(int j = 0 ; j < m1 ; j++){
				arr1[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter n2 and m2 : ");
		int n2 = sc.nextInt(); // representing the number of rows of 2nd matrix.
		int m2 = sc.nextInt(); //  representing the number of columns of 2nd matrix.
		int arr2[][] = new int[n2][m2];
		System.out.println("Enter arr2 elements : ");
		for(int i = 0 ; i < n2 ; i++){
			for(int j = 0 ; j < m2 ; j++){
				arr2[i][j] = sc.nextInt();
			}
		}
		if(checkIfMultIsPossible(n1,m1,n2,m2) == false){
			System.out.println("Invalid input");
		}else{
			matrixMult(arr1,arr2,n1,m1,n2,m2);
		}	
	}
}
