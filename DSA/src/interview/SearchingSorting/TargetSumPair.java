package interview.SearchingSorting;

public class TargetSumPair {
	private static void targetSumPair(int[] arr , int target) {
		int i = 0;
		int j = arr.length-1;
		while(i < j){
			int sum = arr[i] + arr[j];
			if(sum == target){
				System.out.println("Pair with Sum : " + target + " is : " + "(" + i + " , " + j + "). ");
				i++;
				j--;
			}else if(sum < target){
				i++;
			}else{
				j--;
			}
		}
	}
	private static void display(int[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50,60,70,80,90};
		System.out.print("Input Array : ");
		display(arr);
		int target = 100;
		targetSumPair(arr , target);
	}
}
