package interview.Recursion;

import java.util.Scanner;
public class TargetSumSubsets {
	private static void printTargetSumSubsets(int[] arr, int i, String asf, int sos, int tar) {
		if(i == arr.length){
			if(sos == tar){
				System.out.println(asf + ".");
			}
			return;
		}
		if(sos + arr[i] <= tar)
			printTargetSumSubsets(arr , i+1 , asf + arr[i] + ", " , sos + arr[i] , tar);
		printTargetSumSubsets(arr , i+1 , asf , sos , tar);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter n  elements : ");
		for(int i = 0 ; i < n ; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter target : ");
		int tar = sc.nextInt();
		printTargetSumSubsets(arr , 0 , "" , 0 , tar);
	}

	
}
