package interview.Foundation.Recursion;

public class MaxInArray {
	private static int findMax(int[] arr, int i) {
		if(i == arr.length) return Integer.MIN_VALUE;
		int max = findMax(arr , i+1);
		return Math.max(arr[i], max);
	}
	public static void main(String[] args) {
		int arr[] = {-1, -2 , 7 , 9 , 5};
		int max = findMax(arr , 0);
		if(max!=-1)
			System.out.println("Max in Array Using Recursion : " + max);
		else
			System.out.println("Invalid");
	}

}
