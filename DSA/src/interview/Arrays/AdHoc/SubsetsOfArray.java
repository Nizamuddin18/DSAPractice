package interview.Arrays.AdHoc;

import java.util.Scanner;
public class SubsetsOfArray {
	private static void subsetsOfArray(int arr[] , int n){
		int noOfSubsets = (int) Math.pow(2, n);
		for(int i = 0 ; i < noOfSubsets ; i++){
			String set = "";
			int temp = i;
			for(int j = arr.length -1; j>=0 ; j--){
				int rem = temp % 2;
				temp = temp/2;
				if(rem == 0){
					set = "-\t" + set;
				}else{
					set = arr[j] + "\t" + set;
				}
			}
			System.out.println(set);
		}
	}
	
	static void printSubsets(int set[])
    {
        int n = set.length;
  
        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1<<n); i++)
        {
            //System.out.print("{ ");
  
            // Print current subset
            for (int j = 0; j < n; j++)
  
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + "\t");
                else
                	System.out.print("-\t");
            System.out.println();
            //System.out.println("}");
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter n : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		//System.out.println("Enter n elements : ");
		for(int i = 0 ; i < n ; i++){
			arr[i] = sc.nextInt();
		}
		subsetsOfArray(arr,n);
	}

}
