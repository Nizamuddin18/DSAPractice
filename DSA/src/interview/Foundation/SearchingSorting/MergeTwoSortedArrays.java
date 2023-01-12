package interview.Foundation.SearchingSorting;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int arr1[] = {10,20,30,40};
		int arr2[] = {8,15,27};
		int res[] = mergeTwoSortedArrays(arr1 , arr2);
		for(int i = 0 ; i < res.length ; i++)
			System.out.print(res[i] + " ");

	}
	
	
	private static int[] mergeTwoSortedArrays(int arr1[] , int arr2[]){
		int arr3[] = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j]){
				arr3[k++] = arr1[i++];
			}else{
				arr3[k++] = arr2[j++];
			}
		}
		while(i < arr1.length)
			arr3[k++] = arr1[i++];
		while(j < arr2.length)
			arr3[k++] = arr2[j++];
		
		return arr3;
	}

}
