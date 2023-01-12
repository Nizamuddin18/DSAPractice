package interview.DynamicProgramming.Foundation;

public class ClimbStairsVariableJumps {
	public static int climbStairsWithVariableMovesRecursion(int curstair , int totstair , int jumps[]){
		if(curstair == totstair)
			return 1;
		int count = 0;
		for(int jump = 1 ; jump <= jumps[curstair] && curstair + jump <= totstair ; jump++){
			count += climbStairsWithVariableMovesRecursion(curstair + jump , totstair , jumps);
		}
		return count;
	}
	
	public static int climbStairsWithVariableMovesMemoization(int curstair , int totstair , int jumps[] , int cache[]){
		if(curstair == totstair)
			return cache[curstair] = 1;
		if(cache[curstair] != 0)
			return cache[curstair];
		int count = 0;
		for(int jump = 1 ; jump <= jumps[curstair] && jump + curstair <= totstair ; jump++)
			count += climbStairsWithVariableMovesMemoization(curstair + jump , totstair , jumps , cache);
		
		return cache[curstair] = count;
	}
	
	public static int climbStairsWithVariableMovesTabulation2(int totstair , int jumps[]){
		int dp[] = new int[totstair + 1];
		for(int i = totstair ; i >= 0 ; i--){
			if(i == totstair){
				dp[i] = 1;
				continue;
			}
			int count = 0;
			for(int jump = 1 ; jump <= jumps[i] && jump + i <= totstair ; jump++)
				count += dp[i + jump];
			dp[i] = count;
		}
		return dp[0];
	}
	
	public static int climbStairsWithVariableMovesTabulation(int n , int arr[]){
		int dp[] = new int[n+1];
		dp[n] = 1;
		for(int i = n-1 ; i >= 0; i--){
			for(int j = 1 ; j <= arr[i] && i+j <= n; j++){
				dp[i] = dp[i] + dp[i+j];
			}
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		int n = 6;
		int jumps[] = {3,3,0,2,2,3};
		int paths1 = climbStairsWithVariableMovesRecursion(0 , n , jumps);
		int dp[] = new int[n+1];
		int paths2 = climbStairsWithVariableMovesMemoization(0 , n , jumps , dp);
		int paths3 = climbStairsWithVariableMovesTabulation2(n , jumps);
		System.out.println("Different paths via which you can climb to the top(Recursion)  : "  + paths1);
		System.out.println("Different paths via which you can climb to the top(Memoization): "  + paths2);
		System.out.println("Different paths via which you can climb to the top(Tabulation) : "  + paths3);
		
	}

}
