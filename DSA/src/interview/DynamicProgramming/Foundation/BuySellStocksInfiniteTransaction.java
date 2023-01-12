package interview.DynamicProgramming.Foundation;

public class BuySellStocksInfiniteTransaction {
	public static int buySellStocks2(int[] prices) {
		int profit = 0;
		for(int i = 1 ; i < prices.length ; i++){
			if(prices[i] >= prices[i-1])
				profit += prices[i] - prices[i-1];
		}
		return profit;
	}

	public static void main(String[] args) {
		int prices[] = {1,2,3,4,5};
		int profit = buySellStocks2(prices);
		System.out.println("Max Profit for Infinite Transaction : " + profit);
	}
}
