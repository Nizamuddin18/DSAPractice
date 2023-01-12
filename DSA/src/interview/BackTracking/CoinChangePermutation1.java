package interview.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChangePermutation1 {

	public static void main(String[] args) {
		int coins[] =  {2,3,5}; //finite coins
		int target = 7;
		System.out.print("Input coins : ");
		display(coins);
		System.out.println("Target : " + target);
		List<List<Integer>> res = new ArrayList<>();
		boolean visited[] = new boolean[coins.length];
		coinChangePermutations1(coins , 0 , target , res , new ArrayList<>() , visited);
		System.out.println("Coin Change Permutation(Finite Coins) : " + res);

	}
	
	private static void coinChangePermutations1(int[] coins, int sumsofar, int target, 
			List<List<Integer>> res,List<Integer> subres, boolean[] visited) {
		if (sumsofar == target) {
			res.add(new ArrayList<>(subres));
			return;
		}
		for (int i = 0; i < coins.length; i++) {
			if (visited[i] == false && coins[i] + sumsofar <= target) {
				visited[i] = true;
				subres.add(coins[i]);
				coinChangePermutations1(coins, sumsofar + coins[i], target, res, subres, visited);
				subres.remove(subres.size() - 1);
				visited[i] = false;
			}
		}
	}

	private static void display(int[] coins) {
		for(int coin : coins)
			System.out.print(coin  + " ");
		System.out.println();
	}

}
