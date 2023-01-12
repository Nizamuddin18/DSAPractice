package interview.Foundation.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {
	static class Pair implements Comparable<Pair>{
		int first;
		int last;
		Pair(int first , int last){
			this.first = first;
			this.last = last;
		}
		@Override
		public String toString() {
			return first + " " + last;
		}
		@Override
		public int compareTo(Pair p) {
			if(this.first > p.first) return 1;
			else if(this.first < p.first) return -1;
			else return 0;
		}
	}
	
	public static int [][] mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
		
		//Create an Array of Class Pair
		Pair [] pairs = new Pair[arr.length];
		Pair pair;
		//Add matrix value to pairs array
		for(int i = 0 ; i < arr.length ; i++){
			pair = new Pair(arr[i][0] , arr[i][1]);
			pairs[i] = pair;
		}
		Arrays.sort(pairs); // sort the pairs Array
		
		Stack<Pair> st = new Stack<Pair>();
		st.add(pairs[0]);
		for(int i = 1 ; i < pairs.length ; i++){
			if(pairs[i].first <= st.peek().last){
				if(pairs[i].last > st.peek().last)
					st.peek().last = pairs[i].last;
			}else{
				st.push(pairs[i]);
			}
		}
		int ret_arr [][] = new int[st.size()][2];
        int indx = 0;
        for(Pair p : st){
            ret_arr[indx][0] = p.first;
            ret_arr[indx][1] = p.last;
            indx++;
        }
		return ret_arr;
    }
	
	public static void display(int arr[][]){
		for(int i = 0 ; i < arr.length ; i++){
				System.out.print("(" + arr[i][0] + " , " + arr[i][1] + ")");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Input Intervals : ");
		int arr[][] = {
					{1,3},
					{2,6},
					{8,10},
					{15,18}};
		display(arr);
		System.out.println("Output Intervals : ");
		int ret_arr [][] = mergeOverlappingIntervals(arr);
		display(ret_arr);
	}

}
