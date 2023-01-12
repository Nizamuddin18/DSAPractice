package interview.TwoDimensionalArrays;

import java.util.Scanner;

public class TrasnsposeOfMatrix {
	 static void rotate90Clockwise(int arr[][])
	    {
	        // printing the matrix on the basis of
	        // observations made on indices.
	        for (int j = 0; j < arr[0].length; j++)
	        {
	            for (int i = arr.length - 1; i >= 0; i--)
	                System.out.print(arr[i][j] + " ");
	            System.out.println();
	        }
	    }
	    public static void main(String[] args)
	    {
	        int arr[][]= {{11,12,13,14},
					{21,22,23,24},
					{31,32,33,34},
					{41,42,43,44}};
	        rotate90Clockwise(arr);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
private static void transposeMatrix(int[][] arr) {
		
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[0].length ; j++){
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}
	private static void display(int arr[][]){
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[0].length ; j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n :");
		int n = sc.nextInt();
		System.out.println("Enter m :");
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		System.out.println("Enter array elements :");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int arr[][]= {{11,12,13,14,15,16,17},
						{21,22,23,24,25,26,27},
						{31,32,33,34,35,36,37},
						{41,42,43,44,45,46,47},
						{51,52,53,54,55,56,57}};
		
		
		System.out.println("Enter s : ");
		int s = sc.nextInt();
		System.out.println("Enter r : ");
		int r = sc.nextInt();
		transposeMatrix(arr);
		display(arr);
	}*/
}
