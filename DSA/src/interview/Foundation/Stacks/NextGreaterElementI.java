package interview.Foundation.Stacks;

import java.util.Stack;

public class NextGreaterElementI {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] resultOfnums2 = nextGreaterElement1(nums2);
        int length = nums1.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < resultOfnums2.length; j++){
                if (nums1[i] == nums2[j]){
                    result[i] = resultOfnums2[j];
                }
            }
        }
        return result;
    }
	
	public static int[] nextGreaterElement1(int[] nums2) {
        int res[] = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length-1 ; i >= 0 ; i--){
            if(st.isEmpty())
                res[i] = -1;
            else if(!st.isEmpty() && st.peek() > nums2[i])
                res[i] = st.peek();
            else if(!st.isEmpty() && st.peek() <= nums2[i]){
                while(!st.isEmpty() && st.peek() <= nums2[i]){
                    st.pop();
                }
                res[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums2[i]);
        }
        return res;
    }
	
	private static void display(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
		
	public static void main(String[] args) {
		int nums1[] = {2,4};
		int nums2[] = {1,2,3,4};
		int res[] = nextGreaterElement(nums1 , nums2);
		display(res);
	}
}
