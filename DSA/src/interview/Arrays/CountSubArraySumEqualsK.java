package interview.Arrays;

import java.util.HashMap;

public class CountSubArraySumEqualsK {
	public static void display(int arr[]){
		for(int  i = 0  ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static int countSubArraySumEqualsK(int[] arr, int k) {
		HashMap<Integer , Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		map.put(sum, 1);
		for(int i = 0 ; i < arr.length ; i++){
			sum += arr[i];
			int deltasum = sum - k; 
			if(map.containsKey(deltasum)){
				int prev_val = map.get(deltasum);
				count += prev_val;
				map.put(deltasum, prev_val+1);
			}else{
				map.put(deltasum, 1);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("::::: Count Sub Array Sum Equals K :::::");
		int arr[] = {10, 2, -2, -20, 10};
		System.out.print("Input : ");
		display(arr);
		int k = -10;
		System.out.println("K : " + k);
		int count = countSubArraySumEqualsK(arr , k);
		System.out.println("Output : " + count);

	}
	
}
