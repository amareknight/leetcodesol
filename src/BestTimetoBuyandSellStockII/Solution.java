package BestTimetoBuyandSellStockII;

/**
 * Can be done in a single pass
 * Reference : https://leetcode.com/articles/best-time-buy-and-sell-stock-ii/
 * Thought 1: find peak(max), valley(min)
 * Thought 2: if element(i) > elem(i-1), add result by elem(i)-elem(i-1).
 */
public class Solution {
    public int maxProfit(int[] prices) { //mixed idea of Thought1 and Thought2.
        if (prices.length == 0) return 0;
        int min = prices[0], max = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < max) {
                min = prices[i];
                max = min;
            } else {
                result += prices[i] - max;
                max = prices[i];
            }
        }
        return result;
    }
    public int maxProfitSimp(int[] prices) { //simplified implementation according to Thought 2.
        if(prices.length<2) return 0;
        int result = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) result+=prices[i]-prices[i-1];
        }
        return result;
    }
}