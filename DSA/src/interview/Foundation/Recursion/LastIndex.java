package interview.Foundation.Recursion;

import java.util.Scanner;

public class LastIndex {
	public static int lastIndex(int[] arr, int idx, int x) {
		if (idx == arr.length) {
			return -1;
		}
		int lastI = lastIndex(arr, idx + 1, x);
		if (arr[idx] == x && lastI == -1) {
			lastI = idx;
		}
		return lastI;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int data = sc.nextInt();
		System.out.println(lastIndex(arr, 0, data));
	}
}
