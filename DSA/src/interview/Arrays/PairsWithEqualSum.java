package interview.Arrays;

import java.util.HashMap;

class Pair {
	int first;
	int second;

	Pair() {

	}

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class PairsWithEqualSum {
	public static void main(String[] args) {
		int arr[] = {6, 4, 12, 10, 22, 54, 
                32, 42, 21, 11, 8, 2};
		pairsWithEqualSum(arr);
	}

	private static void pairsWithEqualSum(int[] arr) {
		HashMap <Integer , Pair> map = new HashMap<>();
		for(int  i = 0 ; i < arr.length ; i++){
			for(int j = i+1 ; j < arr.length ; j++){
				int sum = arr[i] + arr[j];
				Pair pair = new Pair(arr[i] , arr[j]);
				if(map.containsKey(sum)){
					String pair1 = "(" + arr[i] + "," + arr[j] + ")";
					String pair2 = "(" + map.get(sum).first + "," + map.get(sum).second + ")";
					System.out.println("Pairs :" + pair1 + " and " + pair2 + " have equal sum : " + sum);
				}else
					map.put(sum, pair);
			}
		}
	}
}
