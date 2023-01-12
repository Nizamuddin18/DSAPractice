package interview.HashmapHeaps;

import java.util.HashMap;
import java.util.Map;

public class GetCommon1 {

	public static void main(String[] args) {
		int arr1[] = {1,1,2,2,3,4,3,5};
		int arr2[] = {1,1,1,2,3,3,4,6,7};
		getCommonElements1(arr1 , arr2);
	}

	private static void getCommonElements1(int[] arr1, int[] arr2) {
		Map<Integer , Integer> map = new HashMap<>();
		//Prepare Map 
		for(int key : arr1){
			if(map.containsKey(key) == true){
				map.put(key, map.get(key) + 1);
			}else{
				map.put(key, 1);
			}
		}

		//Removal from Map
		for(int key : arr2){
			if(map.containsKey(key) == true){
				System.out.println(key);
				map.remove(key);
			}	
		}
	}
}
