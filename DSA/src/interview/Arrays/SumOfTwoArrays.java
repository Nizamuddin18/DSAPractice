package interview.Arrays;

import java.util.Scanner;

public class SumOfTwoArrays {
	private static void sumOfTwoArrays(int arr1[] , int arr2[]){
	    int size1 = arr1.length;
	    int size2 = arr2.length;
	    int rsize = size1 > size2 ? size1 + 1 : size2 + 1;
	    int ans[] = new int[rsize];
	    int i = size1-1;
	    int j = size2-1;
	    int carry = 0;
	    for(int k = rsize - 1 ; k >= 0 ; k--){
	    	int val1 = i >= 0 ? arr1[i] : 0;
	    	int val2 = j >= 0 ? arr2[j] : 0;
	    	int sum = val1 + val2 + carry;
	    	ans[k] = sum % 10;
	    	carry = sum/10;
	    	i--;
	    	j--;
	    }
	    if(ans[0] != 0){
	    	System.out.print(ans[0] + "\t");
	    }
	    for(int r = 1 ; r < ans.length ; r++)
	    	System.out.print(ans[r] + "\t");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n1 : " );
		int n1 = sc.nextInt();
		int arr1[] = new int[n1];
		System.out.println("Enter n1 array elements: " );
		for(int i = 0 ; i < arr1.length ; i++){
			arr1[i] = sc.nextInt();
			
		}
		System.out.println("Enter n2 : " );
		int n2 = sc.nextInt();
		int arr2[] = new int[n2];
		System.out.println("Enter n2 array elements : " );
		for(int i = 0 ; i < arr2.length ; i++){
			arr2[i] = sc.nextInt();
		}
		sumOfTwoArrays(arr1,arr2);
	
	}

}
