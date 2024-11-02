package multidimensionalDP.bestTimeToBuyAndSellStockIII;

//Optimized Approach - O(n) time and O(1) space
class Solution {
 public int maxProfit(int[] prices) {
     int n = prices.length;
     int firstBuy = Integer.MAX_VALUE;
     int firstProfit = 0;
     int secondBuy = Integer.MAX_VALUE;
     int secondProfit = 0;

     for (int i = 0; i < n; i++) {
         firstBuy = Math.min(firstBuy, prices[i]);
         firstProfit = Math.max(firstProfit, prices[i] - firstBuy);
         // Adjust secondBuy by "pretending" we already gained firstProfit from the first sale.
         secondBuy = Math.min(secondBuy, prices[i] - firstProfit);
         // Calculate the profit if we sell at prices[i] after the adjusted "secondBuy" cost
         secondProfit = Math.max(secondProfit, prices[i] - secondBuy);
     }     
     return secondProfit;
 }
}