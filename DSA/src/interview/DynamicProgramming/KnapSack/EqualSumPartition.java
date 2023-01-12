package interview.DynamicProgramming.KnapSack;

public class EqualSumPartition {
	public boolean isSumEven(int sum){
		if(sum%2==0)
			return true;
		else
			return false;
	}
	
	public boolean getEqualSumPartition(int wt[] , int length , int sum){
		SubsetSum s = new SubsetSum();
		boolean dp[][] = new boolean[length+1][sum+1];
		boolean ret_val = s.getSubSet(wt, length, sum , dp);
		return ret_val;
	}
	
}
