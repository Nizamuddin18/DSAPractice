package interview.Arrays.AdHoc;
import java.util.ArrayList;
import java.util.List;

/*Given an array, we will find the leaders of the array and print them. 
 Leaders are the elements, who have no element larger than themselves on the right of them in the array.
Example
Input
16,17,4,3,5,2
Output
leaders are 2,5,7*/


public class LeadersInArray {
	private static  List<Integer> findLeadersArray(int[] arr) {
		List<Integer> res_arr = new ArrayList<Integer>();
		int lead = arr[arr.length-1];
		res_arr.add(lead);
		for(int i=arr.length-2;i>=0;i--){
			if(arr[i]>lead){
				lead = arr[i];
				res_arr.add(lead);
			}				
		}
		return res_arr;
	}
	public static void main(String[] args) {
	int arr[] = {16,17,4,3,5,2};
	List<Integer> res_arr = findLeadersArray(arr);
	System.out.println(res_arr);
	}
}
