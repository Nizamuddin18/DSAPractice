package interview.Arrays;

public class FirstOccurenceOfNumber {
	public static int findFirstOccurence(int arr[] , int low , int high , int data){
		while(low <= high){
			int mid = low + (high - low)/2;
			if(arr[mid] == data && low == mid || arr[mid] == data && arr[mid-1] < data){ 
				return mid;
			}else if(arr[mid-1] < data){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {3,5,5,5,6,6,7,7,7,9};
		int data = 3;
		int firstOccur = findFirstOccurence(arr , 0 , arr.length-1 , data);
		System.out.println("First Occurence of " + data + " found at : " + firstOccur);
	}
}
