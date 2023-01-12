package interview.TwoDimensionalArrays;

public class SaddlePoint {
	private static void checkSaddlePoint(int arr[][]){
		//Fing min in First Row
		for(int i = 0 ; i < arr.length ; i++){
			int minindex = 0;
			for(int j = 1 ; j < arr[0].length ; j++){
				if(arr[i][j] < arr[i][minindex]){
					minindex = j;
				}
			}
			boolean flag = true;
			for(int k = 0 ; k < arr.length ; k++){
				if(arr[k][minindex] > arr[i][minindex]){
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println(arr[i][minindex]);
				return;
			}
		}
		System.out.println("Invalid Input");
	}
	public static void main(String[] args) {
		int arr[][] = {{11,99,13,14},
				{21,22,23,24},
				{31,38,33,34},
				{45,42,43,44}};
		checkSaddlePoint(arr);
	}

}
