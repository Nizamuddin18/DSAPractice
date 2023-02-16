package interview.DynamicProgramming.Foundation;

import java.util.Scanner;
public class PaintHouseManyColors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter No of Houses : ");
		int n = sc.nextInt();
		System.out.println("Enter No of Colors : ");
		int c = sc.nextInt();*/
		int arr[][]= {{1,5,7,2,1,4},
					{5,8,4,3,6,1},
					{3,2,9,7,2,3},
					{1,2,4,9,1,7}};
		int rows = arr.length;
		int cols = arr[0].length;
		System.out.println(rows + " " + cols);
		/*System.out.println("Enter Array Elements : ");
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < c ; i++){
				arr[i][j] = sc.nextInt();
			}
		}*/
		int dp[][] = new int [rows][cols];
		paintHouseMultiColor1(arr , rows , cols , dp);
		paintHouseMultiColor2(arr , rows , cols , dp);
	}

	
	public static void paintHouseMultiColor1(int arr[][] , int rows , int cols , int dp[][]){
		for(int j = 0 ; j < cols ; j++){
			dp[0][j] = arr[0][j];
		}
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				int min = Integer.MAX_VALUE;
				for(int k = 0 ; k < dp[0].length ; k++){
					if(k!=j){
						if(dp[i-1][j] < min){
							min = dp[i-1][j];
						}
					}
				}
				dp[i][j] = arr[i][j] + min;
			}
		}
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		int min = Integer.MAX_VALUE;
		for(int k = 0 ; k < dp[0].length ; k++){
			if(dp[dp.length-1][k] < min){
				min = dp[dp.length-1][k];
			}
		}
		System.out.println("MINIMUM NO OF WAYS " + min);
	}
	
	public static void paintHouseMultiColor2(int arr[][] , int rows , int cols , int dp[][]){
		int least = Integer.MAX_VALUE;
		int sleast = Integer.MAX_VALUE;
		for(int j = 0 ; j < cols ; j++){
			dp[0][j] = arr[0][j];
			if(arr[0][j] <= least){
				sleast = least;
				least = arr[0][j];
			}else if(arr[0][j] <= sleast){
				sleast = arr[0][j];
			}
		}
		
		for(int i = 1 ; i < dp.length ; i++){
			int nleast = Integer.MAX_VALUE;
			int snleast = Integer.MAX_VALUE;
			for(int j = 0 ; j < dp[0].length ; j++){
				if(least == dp[i-1][j]){
					dp[i][j] = sleast + arr[i][j];
				}else{
					dp[i][j] = least + arr[i][j];

				}
				if(dp[i][j] <= nleast){
					snleast = least;
					nleast = dp[i][j];
				}else if(dp[i][j] <= sleast){
					snleast = dp[i][j];
				}
			}
			least = nleast;
			sleast = snleast;
		}
		System.out.println("========================");
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("MINIMUM  NO OF WAYS " + least);
	}
}
