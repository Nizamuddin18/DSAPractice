package interview.DynamicProgramming.Foundation;

public class RodCutting {
	static int t[][];
	private static int getMaxValue(int[] price, int[] arr, int piece, int length) {
		t = new int [length+1][piece + 1];
		for(int i = 1 ; i<=length ; i++){
			for(int j = 1 ; j<= piece ; j++){
				if(arr[i-1] <= j){
					t[i][j] = Math.max(t[i][j-arr[i-1]] + price[i-1], 
								t[i-1][j]);
				}else{
					t[i][j] = t[i-1][j];
				}	
			}
		}
		return t[length][piece];
	}
	public static void main(String[] args) {
		int price []  = {2,5,7,8};	
		int length = price.length;
		int piece = 5;
		int arr[] = new int[length];
		for(int i= 0 ; i< length ; i++)
			arr[i] = i+1;
		int maxValue = getMaxValue(price , arr , piece , length);
		System.out.println("Maximum rod cutting price: "+maxValue );
	}


}
