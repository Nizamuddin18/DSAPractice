package interview.Arrays.SlidingWindow;

public class MaxSubArrayOfSumK {

	public static void main(String[] args) {
		int nums[] = {4,1,1,1,2,3,5};
		int target_sum = 5;
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
		System.out.println("Maximum Window Length : " + max_length);
	}

}
