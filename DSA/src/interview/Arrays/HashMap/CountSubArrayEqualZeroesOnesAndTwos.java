package interview.Arrays.HashMap;

import java.util.HashMap;

public class CountSubArrayEqualZeroesOnesAndTwos {
	public static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static int countSubArrayEqualZeroesOnesAndTwos(int[] arr) {
		int zerocount = 0;
		int onecount = 0;
		int twocount = 0;
		int delta10 = onecount - zerocount;
		int delta21 = twocount - onecount;
		String key = "";
		key = delta10 + "#" + delta21;
		HashMap<String  , Integer> map = new HashMap<>();
		map.put(key, 1);
		int i = 0;
		int count = 0;
		while(i < arr.length){
			if(arr[i] == 0){
				zerocount++;
			}else if(arr[i] == 1){
				onecount++;
			}else if(arr[i] == 2){
				twocount++;
			}
			delta10 = onecount - zerocount;
			delta21 = twocount - onecount;
			key = delta10 + "#" + delta21;
			if(map.containsKey(key)){
				count += map.get(key);
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
			i++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int arr[] = {0 ,1 ,0 ,2 ,0 ,1 ,0};
		System.out.print("Input : " );
		display(arr);
		int count = countSubArrayEqualZeroesOnesAndTwos(arr);
		System.out.println("Output : " + count);
	}

}
