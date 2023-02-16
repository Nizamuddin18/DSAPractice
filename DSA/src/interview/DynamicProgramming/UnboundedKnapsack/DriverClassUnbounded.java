package interview.DynamicProgramming.UnboundedKnapsack;

import java.util.Scanner;

public class DriverClassUnbounded {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UnboundedKnapSack unboundedknapsack = new UnboundedKnapSack();
		MaximumRodCutting maxrodcutting = new MaximumRodCutting();
		MaxNoOfWaysCoinChange maxnoofwayschange = new MaxNoOfWaysCoinChange();
		MinNoOfCoin minnoofcoin = new MinNoOfCoin();
		System.out.println("1. Unbounded Knapsack BottomUp");
		System.out.println("2. Rod Cutting BottomUp");
		System.out.println("3. Maximum No of Ways for Coin Change BottomUp");
		System.out.println("4. Minimum No of Coin Change BottomUp");

		System.out.println("Enter Choice : ");
		int choice = sc.nextInt();
		if (choice == 1) {
			int wt[] = { 1, 3, 4, 5 };// weight array
			int val[] = { 30, 40, 50, 70 }; // value array
			int Wc = 8; // Knapsack weight
			int n = wt.length;
			int count = unboundedknapsack.getUnboundedKp(wt, val, n, Wc);
			System.out.println("Maximum Profit for Unbounded KnapSack : " + count);
		} else if (choice == 2) {
			int price[] = { 2, 5, 7, 8 };
			int piece = 5;
			int length = price.length;
			int arr[] = new int[length];
			for (int i = 0; i < length; i++)
				arr[i] = i + 1;
			int maxCount = maxrodcutting.getMaxProfit(arr, price, length, piece);
			System.out.println("Maximum Profit for Rod Cutting : " + maxCount);
		} else if (choice == 3) {
			int coin[] = { 1, 2, 3 };
			int length = coin.length;
			int sum = 5;
			int maxWays = maxnoofwayschange.getMaxNoOfWays(coin, sum, length);
			System.out.println("Maximum No of Ways with which Coins can be added to get the SUM : " + maxWays);
		} else if (choice == 4) {
			int coin[] = { 2, 3, 5, 6 };
			int length = coin.length;
			int sum = 7;
			int minNo = minnoofcoin.getMinimumNoPossible(coin, length, sum);
			System.out.println("Minimum No of Coin Possible that can be added to get the SUM : " + minNo);
		}
	}

}
