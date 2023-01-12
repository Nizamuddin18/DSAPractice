package interview.Foundation.SearchingSorting;

public class PartitionInArray {
	private static int partitiionInArray(int[] arr , int pivot) {
		int i = 0;
		int j = 0;
		while(i < arr.length){
			if(arr[i] <= pivot){
				swap(arr , i , j);
				i++;
				j++;
			}else{
				i++;
			}			
		}
		return j-1;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void display(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {	
		int arr[] = {10,90,60,30,50,40,20,70};
		System.out.print("Array Before Partition : ");
		display(arr);
		int pivot = 40;
		int pi = partitiionInArray(arr , pivot);
		System.out.print("Array Before Partition : ");
		display(arr);
		System.out.println("Partition Index : " + pi);
	}
	

	

}
