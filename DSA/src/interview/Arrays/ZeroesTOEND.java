/**
 * 
 */
package interview.Arrays;

/*Given an array A[] of n elements filled with several integers, 
some of them being zeroes, you need to move all the zeroes to the end.

*Input: A[] = {1, 8, 3, 0, 2, 0, 1, 10, 13, 0}

Output: {1, 8, 3, 2, 1, 10, 13, 0, 0, 0}

Input: A[] = {0, 3, 5, 9, 0, 0, 23, 2}

Output: {3, 5, 9, 23, 2, 0, 0, 0}
*/
public abstract class ZeroesTOEND {
	public static void main(String[] args) {
		int arr[] = {0, 3, 5, 9, 0, 0, 23, 2};
		System.out.print("Input : ");
		for(int i = 0; i< arr.length ; i++)
			System.out.print(arr[i] + " ");
		int res_arr[] = moveZeroesToEnd(arr);
		System.out.println();
		System.out.print("Output : ");
		for(int i =0 ;i < res_arr.length;i++)
			System.out.print(res_arr[i]+" ");
	}

	private static int[] moveZeroesToEnd(int[] arr) {
		int j = 0;
		for(int i = 0 ; i< arr.length ; i ++){
			if(arr[i] != 0){
				arr[j] = arr[i];
				j++;
			}
		}
		for(int i = j; i< arr.length ; i++)
			arr[i] = 0;
		return arr;
	}

}
