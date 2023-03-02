package interview.Arrays.AdHoc;

public class MaxRepetitions {
	private static int findMaxRepetitions(int arr[]){
		int n = arr.length;
		for(int i = 0 ; i < arr.length ; i++){
			arr[arr[i] % n] = arr[arr[i] % n] + n; // add the value in increasing order
		}
		int max = 0 , maxIndex = 0;
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i]/n > max){
				max = arr[i]/n;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	public static void main(String[] args) {
		int arr[] = {0,1,4,4,1,3,3,2,4};
		int ans = findMaxRepetitions(arr);
		System.out.println("Max Repetion Element : " + ans);
	}
}
