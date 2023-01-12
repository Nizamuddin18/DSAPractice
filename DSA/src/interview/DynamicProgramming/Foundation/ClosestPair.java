package interview.DynamicProgramming.Foundation;

import java.util.ArrayList;

public class ClosestPair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr1[] = {1, 4, 5, 7};
		int arr2[] = {10, 20, 30, 40};
		int x = 32;
		ArrayList<Integer> diff = findClosestPair(arr1 , arr2 , x);
		System.out.println("Closest Pair: " + diff);

	}

	private static ArrayList<Integer> findClosestPair(int[] arr1, int[] arr2, int x) {
		int diff = Integer.MAX_VALUE;
		int i =0, j = arr2.length-1;
		int temp1 = 0;
		int temp2 = 0;
		while(i<arr1.length && j >= 0){
			if(Math.abs(arr1[i] + arr2[j] - x) < diff){
				temp1 = arr1[i];
				temp2 = arr2[j];
				diff = Math.abs(arr1[i] + arr2[j] - x);
				
			}
			if(arr1[i]+arr2[j] > x){
				j--;
			}else{
				i++;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(temp1);
		list.add(temp2);
		return list;
	}

}
