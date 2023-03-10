package interview.Arrays.AdHoc;
/*=========================================================================================================================================
 Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
=========================================================================================================================================*/

public class RemoveDuplicates {

	public static void main(String[] args) {
		int arr1[]= {1,1,2};
		int arr2[] = {0,0,1,1,1,2,2,3,3,4};
		int ret_len;
		ret_len = removeDuplicates(arr2);
		for(int i=0;i<=ret_len;i++){
			System.out.print(arr2[i]+" ");
		}
	}

	private static int removeDuplicates(int[] nums) {
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j])
				nums[++j] = nums[i];
		}
		return ++j; // size = index+1
	}

}
