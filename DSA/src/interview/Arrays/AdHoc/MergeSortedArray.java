package interview.Arrays.AdHoc;

public class MergeSortedArray {

	private static int[] findSortedArray(int[] arr1, int length1, int[] arr2, int length2) {
		int i,j,k;
		i=0;
		j=0;
		k=0;
		int arr3[] = new int[length1+length2];
		while(i<arr1.length && j<arr2.length){
			if(arr1[i] < arr2[j]){
				arr3[k] = arr1[i];
				i++;
				k++;
			}
			else if(arr1[i] == arr2[j]){
				arr3[k] = arr1[i];
				i++;
				k++;
				arr3[k]= arr2[j];
				j++;
				k++;
				
			}
			else if(arr1[i] > arr2[j]){
				arr3[k] = arr2[j];
				j++;
				k++;
			}
		}
		while(i<arr1.length){
			arr3[k]= arr1[i];
			i++;
			k++;
		}
		return arr3;
	}

	public static void main(String[] args) {
		int arr1[] = {1,2,3,5};
		int arr2[] = {2,3,4};
		int arr[] = findSortedArray(arr1,arr1.length,arr2,arr2.length);	
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
				
	}

}
