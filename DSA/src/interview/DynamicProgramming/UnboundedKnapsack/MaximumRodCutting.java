package interview.DynamicProgramming.UnboundedKnapsack;

public class MaximumRodCutting {
	static int t[][];
	public int getMaxProfit(int wt[], int price[] , int length , int wc){
		t = new int[length + 1][wc + 1];
		for(int i = 0; i<= length ; i++){
			for(int j = 0 ; j<=wc ; j++){
				if(i ==0 || j ==0)
					t[i][j] = 0;
			}
		}
		for(int i = 1; i<= length ; i++){
			for(int j = 1 ; j<= wc ; j++){
				if(wt[i-1] <= j)
					t[i][j] = Math.max(price[i-1] + t[i][j- wt[i-1]], 
							t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}
		}
		return t[length][wc];		
	}
}
