package interview.SearchingSorting;

public class Sort012 {
	private static int[] sort012(int[] arr) {
		int i = 0;
		int j = 0;
		int k = arr.length-1;
		while(i <= k){
			if(arr[i] == 0){
				swap(arr , i , j);
				i++;
				j++;
			}else if(arr[i] == 1){
				i++;
			}else if(arr[i] == 2){
				swap(arr , i , k);
				k--;
			}
		}
		return arr;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;	
	}
	public static void main(String[] args) {
		int arr[] = {0,1,0,2,0,1,2,2,0,1,1,2,0};
		int ret_arr[] = sort012(arr);
		for(int i = 0 ; i < ret_arr.length ; i++)
			System.out.print(arr[i] + " ");
	}
}
