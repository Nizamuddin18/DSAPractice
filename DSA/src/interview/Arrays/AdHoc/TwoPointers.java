/**
 * 
 */
package interview.Arrays.AdHoc;

/*
 *Given a sorted array A (sorted in ascending order), having N integers,
find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X

*/
public class TwoPointers {
	public static void main(String[] args) {
		int x = 70;
		int a[] = {10,20,35,50,75,80};
		boolean isTwoPointers = findTwoPointers(a,x);
		System.out.println(isTwoPointers);
		
	}

	private static boolean findTwoPointers(int[] arr, int x) {
		int i = 0;
		int j = arr.length -1;
		while(i < j){
			int sum = arr[i] + arr[j];
			if(sum == x) return true;
			else if(sum< x)
				i++;
			else if(sum > x)
				j--;	
		}
		return false;
	}

}
