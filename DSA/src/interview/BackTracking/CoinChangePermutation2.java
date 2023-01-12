package interview.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChangePermutation2 {

	public static void main(String[] args) {
		int coins[] =  {2,3,5}; //infinite coins
		int target = 7;
		System.out.print("Input coins : ");
		display(coins);
		System.out.println("Target : " + target);
		List<List<Integer>> res = new ArrayList<>();
		coinChangePermutations2(coins , 0 , target , res , new ArrayList<>());
		System.out.println("Coin Change Permutation(InFinite Coins) : " + res);

	}
	
	private static void coinChangePermutations2(int[] coins, int sumsofar, int target, 
			List<List<Integer>> res,List<Integer> subres) {
		if (sumsofar == target) {
			res.add(new ArrayList<>(subres));
			return;
		}
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] + sumsofar <= target) {
				subres.add(coins[i]);
				coinChangePermutations2(coins, sumsofar + coins[i], target, res, subres);
				subres.remove(subres.size() - 1);
			}
		}
	}

	private static void display(int[] coins) {
		for(int coin : coins)
			System.out.print(coin  + " ");
		System.out.println();
	}

}
