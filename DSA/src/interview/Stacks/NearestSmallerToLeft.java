package interview.Stacks;

import java.util.Stack;

public class NearestSmallerToLeft {
	private static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private static int[] getNearestSmallerToLeft(int[] arr) {
		int res[] = new int[arr.length];
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(st.isEmpty())
				res[i] = -1;
			else if(st.size() > 0 && st.peek() < arr[i])
				res[i] = st.peek();
			else if(st.size() > 0 && st.peek() >= arr[i]){
				while(st.size() > 0 && st.peek() >= arr[i])
					st.pop();
				if(st.isEmpty())
					res[i] = -1;
				else
					res[i] = st.peek();
			}
			st.push(arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = {4,5,2,10,8};
		System.out.println("Input Array : ");
		display(arr);
		int res[] = getNearestSmallerToLeft(arr);
		System.out.println("Nearest Smaller Element To Left : ");
		display(res);
	}
}
