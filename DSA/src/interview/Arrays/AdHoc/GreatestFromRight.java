package interview.Arrays.AdHoc;

/*1299. Replace Elements with Greatest Element on Right Side
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
After doing so, return the array.
Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
		*/
public class GreatestFromRight {

	public static void main(String[] args) {
		int arr[]  = {15,8,7,9,1,8,6};
		int ret_arr[] = findGreatestElementFromRight(arr);
		for(int i=0;i<ret_arr.length;i++)
		{
			System.out.print(ret_arr[i]+" ");
		}
	}

	private static int[] findGreatestElementFromRight(int[] arr) {
		int size = arr.length;
		int temp,mvr;
		int arr1[] = new int[size];
		for(int i=0;i<arr1.length;i++)
			{arr1[i]  = arr[i];}
		mvr = -1;
		arr1[size-1] = mvr;
		for(int i = size-2;i>=0;i--){
			temp = arr[i+1];
			mvr = Math.max(temp, mvr);
			arr1[i] = mvr;	
		}	
		return arr1;
	}

}
