package interview.DynamicProgramming.Foundation;

public class BuySellStocksInfiniteTransactionCoolDown {
	public static int buySellStocks4(int prices[]){
		int oldbuyingProfit = -prices[0];
		int oldsellingProfit = 0;
		int oldcoolingProfit = 0;
		
		for(int i = 1 ; i < prices.length ; i++){
			int newbuyingstateProfit = 0;
			int newsellingstateProfit = 0;
			int newcoolingstateProfit = 0;
			//buying period
			if(oldcoolingProfit - prices[i] > oldbuyingProfit)
				newbuyingstateProfit = oldcoolingProfit - prices[i];
			else
				newbuyingstateProfit = oldbuyingProfit;
			
			//selling period
			if(prices[i] + oldbuyingProfit > oldsellingProfit)
				newsellingstateProfit = prices[i] + oldbuyingProfit;
			else
				newsellingstateProfit = oldsellingProfit;
			
			//cool down period
			if(oldsellingProfit > oldcoolingProfit)
				newcoolingstateProfit = oldsellingProfit;
			else
				newcoolingstateProfit = oldcoolingProfit;
			
			oldbuyingProfit = newbuyingstateProfit;
			oldsellingProfit = newsellingstateProfit;
			oldcoolingProfit = newcoolingstateProfit;
		}
		
		return oldsellingProfit;
	}
	
	public static void main(String[] args) {
		int prices[] = {10,15,17,20,16,18,22,20,20,22,20,23,25};
		int profit = buySellStocks4(prices);
		System.out.println("Max Profit for Infinite Transaction with Cool Down Period : " + profit);

	}

}
