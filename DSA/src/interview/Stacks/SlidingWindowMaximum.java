package interview.Stacks;
import java.util.Stack;

public class SlidingWindowMaximum {
	
	public static int[] slidingWindowMax(int arr[] , int k){
		int len = arr.length - k + 1;
		int res[] = new int[len];
		int ngr[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		// =========== NGR Index ===================
		for(int i = arr.length - 1 ; i >= 0 ; i--){
			if(st.isEmpty()){
				ngr[i] = arr.length;
			}else if(!st.isEmpty() && arr[st.peek()] > arr[i]){
				ngr[i] = st.peek();
			}else if(!st.isEmpty() && arr[st.peek()] <= arr[i]){
				while(!st.isEmpty() && arr[st.peek()] <= arr[i])
					st.pop();
				if(st.isEmpty())
					ngr[i] = arr.length;
				else
					ngr[i] = st.peek();
			}
			st.push(i);
		}
		// ======== Jumping from NGR to NGR =========
		int j = 0;
		for(int i = 0 ; i < len ; i++){
			if(j < i){
				j = i;
			}
			while(ngr[j] < i+k){
				 j = ngr[j];
			}
			res[i] = j;
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
		int k = 4;
		int res[];
		System.out.println("::::: Sliding Window Maximum(LeetCode 239) :::::");
		System.out.print("Input :");
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		res = slidingWindowMax(arr,k);
		System.out.print("Output:");
		for(int i = 0 ; i < res.length ; i++){
			System.out.print(arr[res[i]] + " ");
		}
		System.out.println();
	}
}
