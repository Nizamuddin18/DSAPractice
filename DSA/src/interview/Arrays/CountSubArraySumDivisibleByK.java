package interview.Arrays;
import java.util.HashMap;

/*
974. Subarray Sums Divisible by K
Given an integer array nums and an integer k, return the number of non-empty subarrays 
that have a sum divisible by k.

A subarray is a contiguous part of an array.
*/

public class CountSubArraySumDivisibleByK {
	public static void display(int arr[]){
		for(int  i = 0  ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static int subArraySumDvisibleByK(int[] arr, int k) {
		// HashMap of Integer vs Frequency of Remainder
		HashMap<Integer , Integer> map = new HashMap<>();
		int rem = 0;
		int freq = 1;
		map.put(rem, freq);
		int i = 0;
		int sum = 0;
		int count = 0;
		while(i < arr.length){
			sum += arr[i];
			rem = sum % k;
			if(rem < 0)
				rem += k;
			if(map.containsKey(rem)){
				count += map.get(rem);
				map.put(rem, map.get(rem)+1);
			}else{
				map.put(rem, 1);
			}
			i++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("::::: Sub Array Sum Divisible by K :::::");
		int arr[] = {2 ,7 ,6 ,1 ,4 ,5};
		int k = 3;
		System.out.print("Input : ");
		display(arr);
		System.out.println("k : " + k);
		int count = subArraySumDvisibleByK(arr , k);
		System.out.println("Output : " + count);
	}

}
