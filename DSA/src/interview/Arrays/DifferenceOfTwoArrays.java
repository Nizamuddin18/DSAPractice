package interview.Arrays;

import java.util.Scanner;

public class DifferenceOfTwoArrays {
	private static void diffOfTwoArrays(int arr1[] , int arr2[]){
	    int size1 = arr1.length;
	    int size2 = arr2.length;
	    int rsize = size2;
	    int ans[] = new int[rsize];
	    int i = size2-1;
	    int j = size1-1;
	    int carry = 0;
	    for(int k = rsize - 1 ; k >= 0 ; k--){
	    	int val2 = i >= 0 ? arr2[i] : 0;
	    	int val1 = j >= 0 ? arr1[j] : 0;
	    	int sub = (val2 + carry) - val1;
	    	if(sub < 0){
	    		sub = sub + 10;
	    		carry = -1;
	    	}else{
	    		carry = 0;
	    	}
	    	ans[k] = sub; 	    	
	    	i--;
	    	j--;
	    }
	    System.out.println("Difference of Two Arrays : ");
		int index = 0;
		while (index < ans.length) {
			if (ans[index] == 0) {
				index++;
			} else {
				break;
			}
		}
		for (int id = index; id < ans.length; id++) {
			System.out.println(ans[id]);
		}
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
		diffOfTwoArrays(arr1,arr2);
	
	}
}
