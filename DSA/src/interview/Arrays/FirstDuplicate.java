package interview.Arrays;

public class FirstDuplicate {
	public static int findFirstDuplicate(int arr[]){
		int minduplicateVal = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(i>minduplicateVal)
				break;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i] == arr[j])	
					minduplicateVal = Math.min(minduplicateVal, j);
					
			}
		}

		return minduplicateVal;
		
	}
	
	private static int findFirstDuplicateOptimal(int[] arr) {
		int index, temp, ret_num, index_val;
		for (int i = 0; i < arr.length; i++) {
			temp = arr[i];
			index = Math.abs(arr[i]) - 1;
			index_val = arr[index];
			if (index_val < 0) {
				ret_num = Math.abs(arr[index]);
				return ret_num;
			}
			arr[index] = -index_val;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {2,1,3,5,6,1,4,3,2};
		int ret_num;
		ret_num= findFirstDuplicateOptimal(arr);
		System.out.println("First Duplicate : " + findFirstDuplicate(arr));
		System.out.println("First Duplicate Optimal : " +  ret_num);
	}
	

}
