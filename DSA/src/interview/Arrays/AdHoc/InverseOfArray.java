package interview.Arrays.AdHoc;

public class InverseOfArray {

	public static void main(String[] args) {
		int arr[] = {3,4,1,2,0};
		int inv[] = inverseOfArray(arr);
	}

	private static int[] inverseOfArray(int[] arr) {
		int inv[] = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++){
			int v = arr[i];
			inv[v] = i;
		}
		return inv;
	}

}
