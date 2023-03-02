package interview.Arrays.AdHoc;
/*/
 * 
 * LeetCode 287
 */
public class FindDuplicateNumber {
	public static int findDuplicate(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
        	if(nums[Math.abs(nums[i])] < 0){
        		return Math.abs(nums[i]);
        	}else{
        		nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        	}
        }
    	return -1;
    }
	
	public static void main(String[] args) {
		int arr[] = {1,3,4,2,2};
		int ans = findDuplicate(arr);
		System.out.println("Duplicate Number : " + ans);
	}
}
