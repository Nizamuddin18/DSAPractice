package interview.DynamicProgramming.MCM;

public class PalindromePartionRecursive {

	public static void main(String[] args) {
		String str = "nitik";
		int i = 0 ; 
		int j = str.length()-1;
		int count = getPartition(str , i , j);
		System.out.println("Minimum Partition : " + count);

	}
	
	public static int getPartition(String str , int i , int j){
		if(i > j)
			return 0;
		if(isPalindrome(str , i , j)){
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		for(int k = i ; k <= j-1 ; k++){
			int temp1 = getPartition(str, i , k);
			int temp2 = getPartition(str , k+1 , j);
			int temp = temp1 + temp2 + 1;
			ans = Math.min(ans, temp);
		}
		return ans;
	}
	
	public static boolean isPalindrome(String str , int i , int j){
		int li = i;
		int ri = j;
		while(li < ri){
			if(str.charAt(li)!=str.charAt(ri)){
				return false;
			}
			li++;
			ri--;
		}
		return true;
	}

}
