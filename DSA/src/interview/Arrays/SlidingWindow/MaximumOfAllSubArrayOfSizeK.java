package interview.Arrays.SlidingWindow;

import java.util.*;

public class MaximumOfAllSubArrayOfSizeK {


    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        List<Integer> ans = getMaxSubArrayOfSizeK(nums, k);
        System.out.println("::::: Maximum Of All SubArray Of Size K :::::");
        System.out.println("Input  : " + ans);
        for(int num : nums)
            System.out.print(num + " ");
        System.out.println();
        System.out.println("k : " + k);
        System.out.println("Output : " + ans);
    }

    private static List<Integer> getMaxSubArrayOfSizeK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        while(end < nums.length){
            int windowSize = end - start + 1;
            // calculation
            while(!queue.isEmpty() && nums[end] > queue.peek()){
                queue.remove();
            }
            queue.add(nums[end]);

            if(windowSize < k){
                end++;
            }else if(windowSize == k){
                list.add(queue.peek());
                // slide
                start++;
                end++;
            }
        }
        return list;
    }
}
