package interview.TwoDimensionalArrays;
import java.util.Scanner;


/*
1  2  3
4  5  6
7  8  9

*/
public class TheStateOfWakand1 {
	
	private static void printMatrix(int[][] arr) {
		int i = 0; //2
		int j = 0; //3
		int row = arr.length; // 3
		int col = arr[0].length; // 3
		int totalcells = row * col;
		int count = 0;
		while(count < totalcells){
			System.out.print(arr[i][j] + "\t"); // 1 4 7 8 5 2 3 6 9
			if(j%2 == 0){ //even column
				i++;
			}else{ // odd column
				i--;
			}
			if(i == row){
				j++;
				i--;
			}else if(i == -1){
				j++;
				i++;
			}
			count++;
		}
		
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
		printMatrix(arr1);
	}

	

}
