package interview.DynamicProgramming.KnapSack;

import java.util.ArrayDeque;

class PairPrint{
	int i;
	int j;
	String psf;
	
	PairPrint(int i, int j , String psf){
		this.i = i;
		this.j = j;
		this.psf = psf;
	}

	@Override
	public String toString() {
		return "[" + i + "-" + j + "-" + "psf=" + psf + "]";
	}
}
public class PrintSubSetSum {

	public static void main(String[] args) {
		int arr[] = {4,2,7,1,3};
		int sum = 10;
		boolean dp[][] = new boolean[arr.length+1][sum+1];
		printSubSet(arr , sum , dp);

	}
	
	public static void printSubSet(int arr[] , int sum , boolean dp[][]){
		int n = arr.length;
		for(int i = 0 ; i < dp.length ; i++){
			dp[i][0] = true;
		}
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1; j < dp[0].length ; j++){
				int val = arr[i-1];
				if(val <= j){
					dp[i][j] = dp[i-1][j-val] || dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[n][sum]);
		ArrayDeque<PairPrint> queue = new ArrayDeque<>();
		queue.add(new PairPrint(n , sum , ""));
		
		while(!queue.isEmpty()){
			PairPrint rem = queue.removeFirst();
			if(rem.j == 0){
				System.out.println(rem.psf + "  ");
			}
			int val = arr[rem.i - 1];
			if(val <= rem.j){
				boolean inc = dp[rem.i - 1][rem.j - val];
				if(inc){
					queue.add(new PairPrint(rem.i -1 , rem.j - val , rem.psf + arr[rem.i-1] +" "));
				}
			}
			boolean exc = dp[rem.i-1][rem.j];
			if(exc){
				queue.add(new PairPrint(rem.i -1 , rem.j, rem.psf));
			}
			
			
		}
	}

}
