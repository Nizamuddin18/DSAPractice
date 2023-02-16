package interview.BackTracking;

import java.util.ArrayList;
import java.util.Scanner;
public class kSubsetPartitions {
	static int counter = 0;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = 3;
		int k = 2;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);
	}
	
	public static void solution(int i, int n, int k, int nos, ArrayList<ArrayList<Integer>> ans) {
		
		if(i > n){
			if(nos == k){
				counter++;
				System.out.print(counter + ". ");
				for(ArrayList<Integer> set : ans){
					System.out.print(set + " ");
				}
				System.out.println();
			}
			return;
		}
		
		for(int j = 0 ; j <ans.size(); j++ ){
			//for non empty sets
			if(ans.get(j).size() > 0){
				ans.get(j).add(i); // adding to non empty set
				solution(i+1 , n , k , nos , ans); // no need to increase the no of sets value
				//Backtracking
				ans.get(j).remove(ans.get(j).size()-1);
			}
			//for empty sets
			else{
				ans.get(j).add(i); // adding to empty sets
				solution(i+1,n,k,nos+1,ans); //  increase the no of sets value by 1
				//BackTracking
				ans.get(j).remove(ans.get(j).size()-1);
				break;
			}
		}
		
	}
}
