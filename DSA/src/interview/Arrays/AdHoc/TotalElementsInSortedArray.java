package interview.Arrays.AdHoc;

public class TotalElementsInSortedArray {

	public static void main(String[] args) {
		FirstOccurenceOfNumber first = new FirstOccurenceOfNumber();
		LastOccurenceOfNumber last = new LastOccurenceOfNumber();
		int arr[] = {3,5,5,5,6,6,7,7,7,9};
		int data = 7;
		int firstOccur = first.findFirstOccurence(arr, 0, arr.length-1, data);
		int lastOccur = last.findLastOccurence(arr, 0, arr.length-1, data);
		int totalElements = lastOccur - firstOccur + 1;
		System.out.println("Total No of Occurence of " + data + " is " + totalElements);
	}
}
