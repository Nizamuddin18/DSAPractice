package interview.Stacks;

import java.util.Stack;

public class LargestAreaHistogram {
	private static int[] getNearestSmallerToLeft(int[] arr) {
		// {1,8,6,2,5,4,8,3,7}
		int ret_arr[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty())
				ret_arr[i] = -1;
			else if (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				ret_arr[i] = st.peek();
			} else if (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				while (!st.isEmpty() && arr[st.peek()] >= arr[i])
					st.pop();
				if (st.isEmpty())
					ret_arr[i] = -1;
				else
					ret_arr[i] = st.peek();
			}
			st.push(i);
		}
		return ret_arr;
	}

	private static int[] getNearestSmallerToRight(int[] arr) {
		int ret_arr[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.isEmpty())
				ret_arr[i] = arr.length;
			else if (st.size() > 0 && arr[st.peek()] < arr[i])
				ret_arr[i] = st.peek();
			else if (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				while (st.size() > 0 && arr[st.peek()] >= arr[i])
					st.pop();
				if (st.isEmpty())
					ret_arr[i] = arr.length;
				else
					ret_arr[i] = st.peek();
			}
			st.push(i);
		}
		return ret_arr;
	}

	private static int[] checkLargestArea(int[] arr, int[] nsr, int[] nsl) {
		int width[] = new int[arr.length];
		int area[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			width[i] = (nsr[i] - nsl[i]) - 1;
		}
		for (int i = 0; i < arr.length; i++) {
			area[i] = arr[i] * width[i];
		}
		return area;
	}

	private static int checkMaxFromArea(int[] res_arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < res_arr.length; i++) {
			if (res_arr[i] > max)
				max = res_arr[i];
		}
		return max;
	}
	
	private static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private static int getLargestAreaHist(int arr[]){
		int nsr1[] = getNearestSmallerToRight(arr); // getNearestSmallerToRight(arr);
		int nsl1[] = getNearestSmallerToLeft(arr); //getNearestSmallerToLeft(arr); 
		int res_arr[] = checkLargestArea(arr, nsr1, nsl1);
		int max = checkMaxFromArea(res_arr); 
		return max;
	}
	public static void main(String[] args) {
		int arr[] = { 2,4};
		int histogram = getLargestAreaHist(arr);
		System.out.println("Largest Area Histogram : " + histogram);
	}

}
