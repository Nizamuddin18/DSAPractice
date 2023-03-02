package interview.Arrays.AdHoc;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		int  nums[] = {1,0,1,1,0};
		int k = 1;
		int j = 0;
		int count = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] == 0) count++;
			while(count > k){
				if(nums[j] == 0) count--;
				j++;
			}
			
			int curr_len = i - j + 1;
			max = Math.max(max, curr_len);
		}
		System.out.println(max);
	}

}
