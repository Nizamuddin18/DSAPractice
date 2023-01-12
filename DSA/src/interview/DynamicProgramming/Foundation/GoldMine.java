package interview.DynamicProgramming.Foundation;

public class GoldMine {
	public static int maxCostGoldMineRecursion(int arr[][] , int x , int y){
		if(y == arr[0].length-1){
			return arr[x][y];
		}
		int max = -(int)1e9;
		//right up call => (x-1)(y+1)
		if(x-1 >= 0 && y+1 < arr[0].length){
			max = Math.max(max, maxCostGoldMineRecursion(arr , x - 1 , y + 1));
		}
		// right call = > y+1
		if(y + 1 < arr[0].length)
			max = Math.max(max, maxCostGoldMineRecursion(arr , x , y + 1));
		//right down call => (x+1)(y+1)
		if(x+1 < arr.length && y+1 < arr[0].length){
			max = Math.max(max, maxCostGoldMineRecursion(arr , x + 1 , y + 1));
		}
		return (max + arr[x][y]);
	}
	
	public static int maxCostGoldMineMemoization(int arr[][] , int x , int y , int dp[][]){
		if(y == arr[0].length-1){
			return dp[x][y] = arr[x][y];
		}

		int max = -(int)1e9;
		//right up call => (x-1)(y+1)
		if(x-1 >= 0 && y+1 < arr[0].length){
			max = Math.max(max, maxCostGoldMineMemoization(arr , x - 1 , y + 1 , dp));
		}
		// right call = > y+1
		if(y + 1 < arr[0].length)
			max = Math.max(max, maxCostGoldMineMemoization(arr , x , y + 1 , dp));
		//right down call => (x+1)(y+1)
		if(x+1 < arr.length && y+1 < arr[0].length){
			max = Math.max(max, maxCostGoldMineMemoization(arr , x + 1 , y + 1 , dp));
		}
		return dp[x][y] = (max + arr[x][y]);
	}
	
	public static int maxCostGoldMineTabulation(int arr[][]){
		int dp[][] = new int[arr.length][arr[0].length];
		for(int col = arr[0].length - 1 ; col >= 0 ; col--){
			for(int row = arr[0].length - 1 ; row >= 0 ; row--){
				if(col == arr[0].length-1){
					dp[row][col] = arr[row][col];
				}else if(row == 0){
					dp[row][col] = arr[row][col] + 
							Math.max(dp[row][col+1], dp[row+1][col+1]);
				}else if(row == arr.length-1){
					dp[row][col] = arr[row][col] + 
							Math.max(dp[row-1][col+1], dp[row][col+1]);
				}else {
					dp[row][col] = arr[row][col] + 
							Math.max(Math.max(dp[row+1][col+1], dp[row-1][col+1]), dp[row][col+1]);
				}
			}
		}
		int max = dp[0][0];
		for(int row = 1 ; row < dp.length ; row++){
			if(dp[row][0] > max)
				max = dp[row][0];
		}
		return max;
	}
	
	public static void main(String[] args) {
		int arr[][] = {{1,1,4},{4,3,6},{1,2,7}};
		int dp[][] = new int[arr.length][arr[0].length];
		int maxCost1 = -(int)1e9;
		int maxCost2 = -(int)1e9;
		int maxCost3 = -(int)1e9;
		maxCost3 = Math.max(maxCost2, maxCostGoldMineTabulation(arr));
		for(int row = 0 ; row < arr.length ; row++){
			maxCost1 = Math.max(maxCost1, maxCostGoldMineRecursion(arr, row , 0));
			maxCost2 = Math.max(maxCost1, maxCostGoldMineMemoization(arr, row , 0 , dp));
		}
		System.out.println("Max Cost Goldmine(Recursion)  : " + maxCost1);
		System.out.println("Max Cost Goldmine(Memoization): " + maxCost2);
		System.out.println("Max Cost Goldmine(Tabulation) : " + maxCost3);
	}

}
