package interview.DynamicProgramming.Foundation;

public class BuySellStocksInfiniteTransactionAndFee {
	public static int buySellStocks3(int[] prices , int fee) {
		int oldbuystateProfit = -prices[0];
		int oldsoldstateProfit = 0;
		
		for(int i = 1 ; i < prices.length ; i++){
			int newbuystateprices = 0;
			int newsoldstateprices = 0;
			//for buying state 
			if(oldsoldstateProfit - prices[i] > oldbuystateProfit)
				newbuystateprices = oldsoldstateProfit - prices[i];
			else
				newbuystateprices = oldbuystateProfit;
			
			//for sold state
			if(oldbuystateProfit + prices[i] - fee > oldsoldstateProfit)
				newsoldstateprices = oldbuystateProfit + prices[i] - fee;
			else
				newsoldstateprices = oldsoldstateProfit;
			
			oldbuystateProfit = newbuystateprices;
			oldsoldstateProfit = newsoldstateprices;	
		}
		
		return oldsoldstateProfit;
	}
	
	public static void main(String[] args) {
		int prices[] = {10,15,17,20,16,18,22,20,20,22,20,23,25};
		int fee = 3;
		int profit = buySellStocks3(prices , fee);
		System.out.println("Max Profit for Infinite Transaction with fee: " + profit);
	}
}
