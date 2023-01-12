package interview.TwoDimensionalArrays;

public class Search2DSortedArray {
	private static void search(int arr[][] , int num){
		boolean flag = false;
		int row = 0;
		int col = 0;
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[i].length ; j++){
				if(arr[i][j] == num){
					flag = true;
					row = i;
					col = j;
					break;
				}
			}
		}
		if(flag){
			System.out.println(row);
			System.out.println(col);
		}else
			System.out.println("Not Found");
	}
	public static void main(String[] args) {
		int arr[][] = {
				{11,12,13,14},
				{21,22,23,24},
				{31,38,33,34},
				{45,42,43,44}
				};
		int n = 43;
		search(arr , n);
	}

}
