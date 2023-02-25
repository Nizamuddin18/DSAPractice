package interview.Heaps;

public class KthLargestOptimized {
	private static int kthLargestElement(int[] arr, int li, int ri, int k) {
			int p = partition(arr , li, ri);
			if(p == k-1)
				return arr[p];
			else if(p >= k)
				return kthLargestElement(arr , li , p-1 , k);
			else
				return kthLargestElement(arr , p+1 , ri , k);
	}

	private static int partition(int arr[] , int start , int end){
		int i = start - 1;
		int x = arr[end];
		for(int j = start ; j <= end - 1 ; j++){
			if(arr[j] <= x){
				i++;
				swap(arr[i] , arr[j]);
			}
		}
		swap(arr[i+1] , arr[end]);
		return i+1;
	}
	
	private static void swap(int i , int j){
		int temp;
		temp = i;
		i = j;
		j = temp;
	}
	public static void main(String[] args) {
		int arr[] = {6,5,0,2,4,7,8,9};
		int k = 2;
		System.out.println("Kth Largest Element(Optimized) : " + kthLargestElement(arr , 0 , arr.length - 1, k));

	}


}
