package interview.DynamicProgramming.Foundation;

public class MinimumCostPath {
	private static void display(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;

		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int getMinimumCostTabulation(int[][] arr) {
		int dp[][] = new int[arr.length][arr[0].length];
		for(int i = dp.length - 1 ; i >= 0 ; i--){
			for(int j = dp[0].length-1 ; j >= 0 ; j--){
				if(i == dp.length-1 && j == dp[0].length-1){
					 // last cell
					dp[i][j] = arr[i][j];
				}else if(i == dp.length-1){ // last row
					dp[i][j] = dp[i][j+1] + arr[i][j];
				}else if(j == dp[0].length-1){ // last column
					dp[i][j] = dp[i+1][j] + arr[i][j];
				}else{ // middle part
					dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + 
								arr[i][j];
				}
			}
		}
		return dp[0][0];
	}
	
	private static int getMinimumCostTabulation2(int arr[][]){
		int dp[][] = new int[arr.length][arr[0].length];
		for(int i = dp.length-1 ; i >= 0 ; i--){
			for(int j = dp[0].length-1 ; j >= 0 ; j--){
				if(i == dp.length-1 && j == dp[0].length-1){
					dp[i][j] = arr[i][j];
					continue;
				}
				int minCost = (int)1e9;
				//right call
				if(j + 1 < dp[0].length)
					minCost = Math.min(minCost, dp[i][j+1]);
				//down call
				if(i + 1 < dp.length)
					minCost = Math.min(minCost, dp[i+1][j]);
				dp[i][j] = minCost + arr[i][j];
			}
		}
		return dp[0][0];
	}
	
	private static int getMinimumCostRecursion(int arr[][] , int x , int y){
		if(x == arr.length-1 && y == arr[0].length-1){
			return arr[x][y];
		}
		int minCost = (int)1e9;
		//right call
		if(y + 1 < arr[0].length)
			minCost = Math.min(minCost, getMinimumCostRecursion(arr , x , y + 1));
		
		//down call
		if(x + 1 < arr.length)
			minCost = Math.min(minCost, getMinimumCostRecursion(arr , x + 1 , y));
		
		
		return (minCost + arr[x][y]);
	}
	
	private static int getMinimumCostMemoization(int arr[][] , int x , int y , int dp[][]){
		if(x == arr.length-1 && y == arr[0].length-1){
			return dp[x][y] = arr[x][y];
		}
		int minCost = (int)1e9;
		//right call
		if(y + 1 < arr[0].length)
			minCost = Math.min(minCost, getMinimumCostMemoization(arr , x , y + 1 , dp));
		
		//down call
		if(x + 1 < arr.length)
			minCost = Math.min(minCost, getMinimumCostMemoization(arr , x + 1 , y , dp));
		
		
		return dp[x][y] = (minCost + arr[x][y]);
	}
	
	public static void main(String[] args) {
		int arr[][] = {{1,3,1},{1,5,1},{4,2,1}};
		int dp[][] = new int[arr.length][arr[0].length];
		int mincost1 = getMinimumCostTabulation(arr);
		int mincost2 = getMinimumCostRecursion(arr , 0 , 0);
		int mincost3 = getMinimumCostMemoization(arr , 0 , 0, dp);
		int mincost4 = getMinimumCostTabulation2(arr);
		System.out.println("Minimum Cost Traversal in Maze(Tabulation) : " + mincost1);
		System.out.println("Minimum Cost Traversal in Maze(Recursion)  : " + mincost2);
		System.out.println("Minimum Cost Traversal in Maze(Memoization): " + mincost3);
		System.out.println("Minimum Cost Traversal in Maze(Tabulation2): " + mincost4);

	}
	
}
