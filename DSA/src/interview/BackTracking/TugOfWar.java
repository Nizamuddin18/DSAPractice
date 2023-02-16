package interview.BackTracking;

import java.util.ArrayList;
import java.util.Scanner;
public class TugOfWar {
	static int mindiff = Integer.MAX_VALUE;
	static String ans = "";
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = 6;
		int[] arr = new int[n];
		System.out.println("Enter Array Elements : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(ans);

	}
	
	public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
		//================Base Case starts===================
		
		if(vidx == arr.length){
			int delta = Math.abs(soset1 - soset2);
			if(delta < mindiff){
				mindiff = delta;
				ans = set1 + " " + set2;
			}
			return;
		}
		//================Base Case Ends===================
		//in any set max of (n + 1)/2 elemnts can be added 
		//========SET1======
		if(set1.size() < (arr.length+1) / 2){
			set1.add(arr[vidx]); // add the elements to set1
			solve(arr , vidx+1 , set1 , set2 , soset1 + arr[vidx] , soset2); // call the function
			//BackTrack
			set1.remove(set1.size()-1);
		}
		//========SET2======
		if(set2.size() < (arr.length+1) / 2){
			set2.add(arr[vidx]);
			solve(arr , vidx+1 , set1 , set2 , soset1 , soset2 + arr[vidx]);
			set2.remove(set2.size()-1);
		}

	}

}
