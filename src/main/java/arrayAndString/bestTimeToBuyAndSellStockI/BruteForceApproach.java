package arrayAndString.bestTimeToBuyAndSellStockI;

//Brute Force Approach - O(n^2) time and O(1) space
public class BruteForceApproach {
	public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
