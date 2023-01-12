package interview.BackTracking;
import java.util.*;
public class KSubSetWithEqualSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = 6;
		int[] arr = new int[n];
		int sum = 0;
		System.out.println("Enter Elements in Array : ");
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		
		int k = 3;
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
	}
	

	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int nossf, ArrayList<ArrayList<Integer>> ans) {
		//================Base Case starts===================
		if(vidx == arr.length){
			if(nossf == k){ // No. of Sets So Far has to be equal to K
				boolean flag = true;
				for(int  i = 0 ; i < subsetSum.length -1 ; i++){
						if(subsetSum[i]!=subsetSum[i+1]){ // subsetSum Contains the sum for all individual Set Sum
							//If any sum is mismatching then Equal Sum Partitioning is not possible
							flag = false;
							break;
						}
					
					
				}
				if(flag){
					for(ArrayList<Integer> partition : ans){
						System.out.print(partition + " ");
					}
					System.out.println();
				}
			}
			return;
		}
		//================Base Case ends===================
		//ArrayList of ArrayList of Integers -> "ans" is created and has no value in the beginning
		for(int  i = 0; i < ans.size() ; i++){
			if(ans.get(i).size() > 0){//Adding the value to non empty set
				ans.get(i).add(arr[vidx]); // add the vidx index value to non empty Set
				subsetSum[i] += arr[vidx];  // increase that index subset Sum
				solution(arr , vidx + 1 , n , k , subsetSum , nossf , ans); // call the function for next index but do not increase the count since value is added to non empty set
				//BackTracking
				subsetSum[i] -= arr[vidx];
				ans.get(i).remove(ans.get(i).size()-1);
				
			}else{//When ans is empty
				ans.get(i).add(arr[vidx]); // add the vidx index value to 1st empty Set
				subsetSum[i] += arr[vidx]; // increase that index subset Sum
				solution(arr , vidx + 1 , n , k , subsetSum , nossf+1 , ans); // call the function for next index and increase the count of No. of Subset found so far
				//BackTracking
				subsetSum[i] -= arr[vidx];
				ans.get(i).remove(ans.get(i).size()-1);
				//break is necessary otherwise it will generate all the permutations for same set of values
				break;
			}
		}
	}

}
