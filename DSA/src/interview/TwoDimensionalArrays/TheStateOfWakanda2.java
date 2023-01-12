package interview.TwoDimensionalArrays;

import java.util.Scanner;

public class TheStateOfWakanda2 {

	private static void printMatrix(int[][] arr) {
		for(int gap = 0 ; gap < arr.length ; gap++){
			for(int row = 0 ; row <= arr.length - 1 - gap; row++){
				int col = row+gap;
				System.out.println(arr[row][col]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int arr1[][] = new int[n1][n1];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n1; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		printMatrix(arr1);
	}
}
