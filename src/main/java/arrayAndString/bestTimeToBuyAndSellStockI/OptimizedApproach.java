package arrayAndString.bestTimeToBuyAndSellStockI;

//Optimized Approach - O(n) time and O(1) space
public class OptimizedApproach {
	public int maxProfit(int[] prices) {
        int maxProfit = 0, minStockVal = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minStockVal = Math.min(minStockVal, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minStockVal);
        }
        return maxProfit;
    }
}
