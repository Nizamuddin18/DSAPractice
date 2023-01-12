package interview.Arrays;

import java.util.HashMap;
/*
523. Continuous Subarray Sum
Given an integer array nums and an integer k, 
return true if nums has a continuous subarray of size at least 
two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always 
a multiple of k.

*/
public class ContinuousSubArraySum {
	public static void display(int arr[]){
		for(int  i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static boolean checkSubarraySum(int[] arr, int k) {
		// HashMap for Remainder vs ArrayIndex
		HashMap<Integer , Integer> map = new HashMap<>();
		int rem = 0;
		int intialIndex = -1;
		map.put(rem, intialIndex);
		int sum = 0;
		for(int  i = 0 ; i < arr.length ; i++){
			sum += arr[i];
			rem = sum % k;
			if(rem < 0) // if remainder becomes negative
				rem = rem + k;
			if(map.containsKey(rem)){
				int count = i - map.get(rem);
				if(count > 1) return true;
			}else{
				map.put(rem, i);
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		int arr[] = {23,2,4,6,7};
		int k = 6;
		System.out.print("Input : ");
		display(arr);
		System.out.println("K  : " + k);
		boolean output = checkSubarraySum(arr , k);
		System.out.println("Output : " + output);
	}

}
