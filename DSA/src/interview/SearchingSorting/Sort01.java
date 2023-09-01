package interview.SearchingSorting;

public class Sort01 {
	private static int[] sort01(int[] arr) {
		int i = 0;
		int j = 0;
		while(i < arr.length){
			if(arr[i] == 0){
				swap(arr , i , j);
				i++;
				j++;
			}else{
				i++;
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
		int arr[] = {0,1,0,1,0,1,1,0};
		int ret_arr[] = sort01(arr);
		for(int i = 0 ; i < ret_arr.length ; i++)
			System.out.print(arr[i] + " ");
	}
}
