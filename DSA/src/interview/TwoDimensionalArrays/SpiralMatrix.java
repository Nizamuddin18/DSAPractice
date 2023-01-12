package interview.TwoDimensionalArrays;

import java.util.Scanner;

public class SpiralMatrix {
	private static int[] fillOneDfromShell(int arr[][] , int s) {
		int maxrow = arr.length -s; // 3
		int minrow = s-1; // 1
		int mincol = s-1; //1 
		int maxcol = arr[0].length - s;
		int size = 2 * (maxcol - mincol + maxrow - minrow);
		int oned[] = new int[size];
		int idx = 0;
		for(int row = minrow ; row <= maxrow ; row++){
			oned[idx] = arr[row][mincol];
			idx++;
		}
		mincol++;
		for(int col = mincol ; col <= maxcol ; col++){
			oned[idx] = arr[maxrow][col];
			idx++;
		}
		maxrow--;
		for(int row = maxrow ; row >= minrow ; row--){
			oned[idx] = arr[row][maxcol];
			idx++;
		}
		maxcol--;
		for(int col = maxcol ; col >= mincol ; col--){
			oned[idx] = arr[minrow][col];
			idx++;
		}
		minrow++;
	/*	for(int i = 0 ; i < oned.length ; i++)
			System.out.print(oned[i] + "\t");*/
		return oned;
	}
	
	private static void shellRotate(int arr[][] , int s , int r){
		int [] oneDarr = fillOneDfromShell(arr , s);
		System.out.println("1 D array : ");
		for(int i = 0 ; i < oneDarr.length ; i++)
			System.out.print(oneDarr[i] + "\t");
		rotate(oneDarr , r);
		System.out.println("\n1 D array after rotation : ");
		for(int i = 0 ; i < oneDarr.length ; i++)
			System.out.print(oneDarr[i] + "\t");
		fillShellFromOneD(arr , s , oneDarr);
	}
	
	private static void fillShellFromOneD(int[][] arr, int s, int[] oneDarr) {
		int maxrow = arr.length -s; // 3
		int minrow = s-1; // 1
		int mincol = s-1; //1 
		int maxcol = arr[0].length - s;
		int size = 2 * (maxcol - mincol + maxrow - minrow);
		//int oned[] = new int[size];
		int idx = 0;
		for(int row = minrow ; row <= maxrow ; row++){
			arr[row][mincol] = oneDarr[idx]; 
			idx++;
		}
		mincol++;
		for(int col = mincol ; col <= maxcol ; col++){
			arr[maxrow][col] = oneDarr[idx];
			idx++;
		}
		maxrow--;
		for(int row = maxrow ; row >= minrow ; row--){
			arr[row][maxcol] = oneDarr[idx];
			idx++;
		}
		maxcol--;
		for(int col = maxcol ; col >= mincol ; col--){
			arr[minrow][col] = oneDarr[idx];
			idx++;
		}
		minrow++;
		System.out.println("Output");
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0; j < arr[0].length ; j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void reverse(int[] a, int li, int hi) {
		int i = li;
		int j = hi;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}

	public static void rotate(int[] arr, int k) {
		k = k % arr.length;
		if (k < 0) {
			k = k + arr.length;
		}
		reverse(arr, 0, arr.length - k - 1);
		reverse(arr, arr.length - k, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	private static void display(int[][] arr) {
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[i].length ; i++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter n :");
		int n = sc.nextInt();
		//System.out.println("Enter m :");
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		//System.out.println("Enter array elements :");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		/*int arr[][]= {{11,12,13,14,15,16,17},
						{21,22,23,24,25,26,27},
						{31,32,33,34,35,36,37},
						{41,42,43,44,45,46,47},
						{51,52,53,54,55,56,57}};
		*/
		
		//System.out.println("Enter s : ");
		int s = sc.nextInt();
		//System.out.println("Enter r : ");
		int r = sc.nextInt();
		shellRotate(arr , s , r);
		//display(arr);
	}

	
}
