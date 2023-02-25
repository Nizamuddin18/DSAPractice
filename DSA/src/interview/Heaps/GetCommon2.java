package interview.Heaps;

import java.util.HashMap;
import java.util.Map;

public class GetCommon2 {

	public static void main(String[] args) {
		int arr1[] = {1,1,2,3,2,4,4,5};
		int arr2[] = {1,2,4,3,2,1,3,7};
		getCommonElements2(arr1 , arr2);

	}
	
	private static void getCommonElements2(int[] arr1, int[] arr2) {
		Map<Integer , Integer> map = new HashMap<>();
		//Prepare Map 
		for(int key : arr1){
			if(map.containsKey(key) == true){
				map.put(key, map.get(key) + 1);
			}else{
				map.put(key, 1);
			}
		}
		System.out.println(map);
		
		//Removal from Map
		for(int key : arr2){
			if(map.containsKey(key) == true && map.get(key) > 0){
				int oldval = map.get(key);
				System.out.println(key);
				map.put(key , oldval-1);
			}	
		}
	}
}
