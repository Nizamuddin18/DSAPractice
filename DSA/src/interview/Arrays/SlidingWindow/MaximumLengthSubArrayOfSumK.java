package interview.Arrays.SlidingWindow;

public class MaximumLengthSubArrayOfSumK {
	/*
	 * Find the Maximum Length Sub-Array where sum of the SubArray equals target_sum from the given Input Array
	 * */
	public static void main(String[] args) {
		int nums[] = {1,2,3};
		int target_sum = 3;
		int i = 0;
		int j = 0;
		int curr_sum = 0;
		int max_length = Integer.MIN_VALUE;
		while(j < nums.length){
			curr_sum += nums[j];
			if(curr_sum < target_sum)
				j++;
			else if(curr_sum == target_sum){
				int curr_window_size = j - i + 1;
				max_length = Math.max(max_length, curr_window_size);
				j++;
			}
			else if(curr_sum > target_sum){
				while(curr_sum > target_sum){
					curr_sum = curr_sum - nums[i];
					i++;
				}
				j++;
			}
		}
		System.out.println("::::: Max Length SubArray of Sum K :::::");
		System.out.print("Input  : ");
		for(int num : nums)
			System.out.print(num + " ");
		System.out.println();
		System.out.println("target Sum : " + target_sum);
		System.out.println("Output : " + max_length);
	}

}
