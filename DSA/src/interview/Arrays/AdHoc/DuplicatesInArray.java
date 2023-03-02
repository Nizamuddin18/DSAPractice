package interview.Arrays.AdHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*=============================================================================================================================
Given an array of integers, 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
=============================================================================================================================*/
public class DuplicatesInArray {

	public static void main(String[] args) {
		int arr[] = {4,3,2,7,8,2,3,1};	
		List<Integer> output_ret = new ArrayList<Integer>();
		output_ret = finDuplicates(arr);
		System.out.println("OUTPUT LIST OF DUPLICATES"+output_ret);
	}

	private static List<Integer> finDuplicates(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int index = Math.abs(arr[i]) - 1;
			if (arr[index] < 0)
				list.add(Math.abs(arr[index]));
			arr[index] = -arr[index];
		}
		Collections.reverse(list);
		return list;
	}

}
