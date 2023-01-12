package interview.Arrays;
/*/
 * LeetCode (268)
 * Question :
 * Array is of length : (n-1)
 * Array Elements is of Range : 1 <= arr[i] <= n
 */
public class MissingNumber {
	private static int findMissingNumber(int arr[], int n) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < arr.length; i++)
			x = x ^ arr[i];
		for (int i = 1; i <= n; i++)
			y = y ^ i;

		return x ^ y;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 6, 3, 7, 8 };
		int n = 8;
		int ans = findMissingNumber(arr, n);
		System.out.println("Missing Element is : " + ans);
	}
}
