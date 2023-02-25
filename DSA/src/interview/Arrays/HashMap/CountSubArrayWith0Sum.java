package interview.Arrays.HashMap;

import java.util.HashMap;

public class CountSubArrayWith0Sum {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int countSubArraySum0Sum(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		map.put(sum, 1);
		for(int i = 0 ; i < arr.length ; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				count += map.get(sum);
				int prev_val = map.get(sum);
				map.put(sum, prev_val + 1);
			}else{
				map.put(sum, 1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println("::::: Count SubArray With 0 Sum");
		int arr[] = { 6,-1,-3,4,-2,2,4,6,-12,-7};
		System.out.print("Input : ");
		display(arr);
		int count = countSubArraySum0Sum(arr);
		System.out.println("Output : " + count);
	}

}
