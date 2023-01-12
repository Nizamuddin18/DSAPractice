package interview.Arrays;

public class LastOccurenceOfNumber {
	public static int findLastOccurence(int arr[] , int low , int high , int data){
		while(low <= high){
			int mid = low + (high - low)/2;
			if(arr[mid] == data && high == mid || arr[mid] == data && arr[mid+1] > data)
				return mid;
			else if(arr[mid+1] <= data)
				low = mid+1;
			else
				high = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {3,5,5,5,6,6,7,7,7,9};
		int data = 7;
		int lastOccur = findLastOccurence(arr , 0 , arr.length-1 , data);
		System.out.println("Last Occurence of " + data + " found at : " + lastOccur);
	}
}
