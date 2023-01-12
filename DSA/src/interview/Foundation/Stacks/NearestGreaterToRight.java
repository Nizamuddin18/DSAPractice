package interview.Foundation.Stacks;
import java.util.*;
public class NearestGreaterToRight {
	private static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int[] getNearestToRight(int arr[]){
		int res[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for(int i = arr.length-1 ; i >= 0 ; i--){
			if(st.isEmpty()){
				res[i] = -1;
			}else if(!st.isEmpty() && st.peek() > arr[i]){
				res[i] = st.peek();
			}else if(!st.isEmpty() && st.peek() <= arr[i]){
				while(!st.isEmpty() && st.peek() <= arr[i]){
					st.pop();
				}
				if(st.isEmpty()){
					res[i] = -1;
				}else{
					res[i] = st.peek();
				}
			}
			st.push(arr[i]);
		}
		return res;
	}
	
	private static int[] getNearestToRight2(int nums[]) {
		int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i);
        }
        for(int i=n-1;i>=0;i--){
            if(ans[i] == -1){
                while(!stack.isEmpty() && nums[stack.peek()] <=nums[i]){
                    stack.pop();
                }
                ans[i] = stack.isEmpty() ? -1 : nums[stack.peek()];
            }
            stack.push(i);
        }
        return ans;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,1};
		System.out.println("Input Array : ");
		display(arr);
		int res[] = getNearestToRight2(arr);
		System.out.println("Nearest Greater Element To Right : ");
		display(res);
	}
}
