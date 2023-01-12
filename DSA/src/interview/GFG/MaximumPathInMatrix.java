package interview.GFG;

public class MaximumPathInMatrix {
	
	public static void maxPath(int arr[][] , int N){
		 int dp[][] = new int[N][N];
	       for(int i = dp.length - 1 ; i >= 0 ; i--){
	           for(int j = dp[0].length -1 ; j >= 0 ; j--){
	               if(i == dp.length - 1 ){
	                   dp[i][j] = arr[i][j];
	               }else if(j == 0){
						dp[i][j] = Math.max(dp[i+1][j] , dp[i+1][j+1]) + arr[i][j];
	               }else if(j == dp[0].length-1){
						dp[i][j] = Math.max(dp[i+1][j] , dp[i+1][j-1]) + arr[i][j];
	               }else{
	                   dp[i][j] = Math.max( dp[i+1][j], Math.max(dp[i+1][j+1] , dp[i+1][j-1])) + arr[i][j];
	               }
	           }
	       }
	      display(dp);
	      int count = getMaxFromRow(dp);
	      System.out.println("Max Path : " + count);
	}
	
	public static void display(int dp[][]){
		 for(int i = 0 ; i < dp.length ; i++){
	    	   for(int j = 0 ; j < dp[0].length ; j++){
	    		   System.out.print(dp[i][j] + " ");
	    	   }
	    	   System.out.println();
	       }
	}
	public static int getMaxFromRow(int dp[][]){
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < dp[0].length ; i++){
			if(dp[0][i] > max)
				max = dp[0][i];
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{348, 391},{618, 193}};
		int n = 2;
		maxPath(matrix , n);
	}

}
