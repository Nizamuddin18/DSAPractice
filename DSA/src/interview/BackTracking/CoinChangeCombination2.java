package interview.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeCombination2 {

	public static void main(String[] args) {
		int coins[] =  {2,3,5,7}; //finite coins
		int target = 7;
		System.out.print("Input coins : ");
		display(coins);
		System.out.println("Target : " + target);
		List<List<Integer>> res = new ArrayList<>();
		coinChangeCombinations2(0 , coins , 0 , target , res , new ArrayList<>());
		System.out.println("Coin Change Combination(InFinite Coins) : " + res);
	}
	private static void display(int[] coins) {
		for(int coin : coins)
			System.out.print(coin  + " ");
		System.out.println();
	}

	private static void coinChangeCombinations2(int i, int[] coins, int sumsofar, int target, 
			List<List<Integer>> res,List<Integer> subres) {
		if(target == sumsofar){
			res.add(new ArrayList<>(subres));
			return;
		}
		if(i == coins.length) return;
		//yes call
		if(coins[i] + sumsofar <= target){
			subres.add(coins[i]);
			coinChangeCombinations2(i, coins , sumsofar + coins[i], target , res , subres);
			subres.remove(subres.size()-1);
		}
		//no call
		coinChangeCombinations2(i+1 , coins , sumsofar , target , res , subres);
		
	}
}
