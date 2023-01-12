package interview.DynamicProgramming.Foundation;

public class BuySellStocksOneTransaction {

	public static void main(String[] args) {
		int prices[] = {10,15,17,20,16,18,22,20,20,22,20,23,25};
		int profit = buySellStocks1(prices);
		System.out.println("Max Profit for Single Transaction : " + profit);
	}

	public static int buySellStocks1(int[] prices) {
		int leastSoFar = Integer.MAX_VALUE;	// Least buying price so far
		int overallProfit = 0;				// Overall Profit
		int currentProfit = 0; 				// Todays Profit
		for(int i = 0 ; i < prices.length ; i++){
			if(prices[i] < leastSoFar)
				leastSoFar = prices[i];
			currentProfit = prices[i] - leastSoFar;
			if(overallProfit < currentProfit)
				overallProfit = currentProfit;
		}
		return overallProfit;
	}
}
