package interview.DynamicProgramming.KnapSack;

import java.util.Scanner;
public class DriverClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		KnapSack01 knapsack = new KnapSack01();
		SubsetSum subset = new SubsetSum();
		EqualSumPartition equalsumpartition = new EqualSumPartition();
		CountSubsetSum countsum = new CountSubsetSum();
		MinDifferenceSubset mindiff = new MinDifferenceSubset();
		SubsetSumWithGivenDifference sswithDiff = new SubsetSumWithGivenDifference();
		System.out.println("1. 0-1 KnapSack Bottom Up");
		System.out.println("2. SubsetSum Bottom Up");
		System.out.println("3. EqualSum Partition Bottom Up");
		System.out.println("4. Count of Subset with Given Sum Bottom Up");
		System.out.println("5. SubSetSum with Minimum Difference Bottom Up");
		System.out.println("6. SubSetSum with Given Difference Bottom Up");
		System.out.println("Enter Choice : ");
		int choice = sc.nextInt();
		if(choice == 1){
			int wt[] = {2 ,5 ,1 ,3 ,4};// weight array 
			int val[] = {15,14,10,45,30}; //  value array
			int Wc = 7; // Knapsack weihgt
			int n = wt.length;  // length of the items
			
			// calling the function which takes weight and value array as an input and returns the Maximum profit
			int dp[][] = new int[n+1][Wc+1];
			
			int maxProfit3 = knapsack.KnapSack01Tabulation1(wt, val, n, Wc); 
			System.out.println("Max profit of 0/1 KnapSack (Tabulation) : "+ maxProfit3);
			
		/*	//int maxProfit1 = knapsack.KnapSack01Recursion(wt, val, n, Wc); 
			System.out.println("Max profit of 0/1 KnapSack (Recursion ) : "+ maxProfit1);
			int maxProfit2 = knapsack.KnapSack01Memoization(wt, val, n, Wc , dp); 
			System.out.println("Max profit of 0/1 KnapSack (Memoization): "+ maxProfit2);
			int maxProfit4 = knapsack.KnapSack01Tabulation2(wt, val, n, Wc , dp); 
	 		System.out.println("Max profit of 0/1 KnapSack (Tabulation2): "+ maxProfit4);*/
			
		}else if(choice == 2){
			int k[]= {1,2,3,4,5};
			int sum = 16;
			int n = k.length;
			boolean dp[][] = new boolean[n+1][sum +1];
			boolean isPresent = subset.getSubSet(k, n, sum , dp);
			System.out.println("Is Subset Present : " + isPresent);	
			
		}else if(choice == 3){	
			int wt[] = {1,5,11,5};
			int length = wt.length;
			int k = 2;
			int sum = 0;
			boolean ret_val;
			for(int i = 0;i< length ; i++)
				sum += wt[i];
			boolean isEqual = equalsumpartition.isSumEven(sum);
			if(isEqual){
				sum = sum/k;
				ret_val = equalsumpartition.getEqualSumPartition(wt, length, sum);		
			}else
				ret_val = false;
			System.out.println("Is Equal Sum Partition Sum Possible : " +ret_val);
				
		}else if(choice == 4){
			int wt[] = {1,1,2,3};
			int sum = 4;
			int length = wt.length;
			int count  = countsum.getCountOfSubset(wt, length, sum);
			System.out.println("No of SubSet Sum Possible : " + count);
			
		}else if(choice == 5){
			int arr[] = {1,3,4,10,15};
			int n = arr.length;
			int sum = mindiff.getRange(arr, n);  // sum will get the range of the values in array i.e the total Range;
			boolean[] ret_arr = mindiff.getSubset(arr, n, sum);   // this method will return the last row of the matrix;
			int min_val = mindiff.getMinDiff(ret_arr, sum, n, arr);   // this method will give the min value
			System.out.println("MIN VALUE : "+min_val);
			
		}else if(choice == 6){
			int arr[] = {1,3,5,7};
			int diff = 1;
			int n = arr.length;
			int sum = mindiff.getRange(arr, n);  // sum will get the range of the values in array i.e the total Range;
			int subsetSum1 = (diff + sum) / 2;
			int count = sswithDiff.getCountOfSubset(n, subsetSum1, arr);
			System.out.println("COUNT OF SUBSET WITH GIVEN DIFFERENCE : " +count );
		}	

	}

}
