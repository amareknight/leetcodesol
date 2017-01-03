package BestTimetoBuyandSellStockIII;

/**
 * References:
 * 1. https://discuss.leetcode.com/topic/7028/java-solution-with-just-two-traverses (maxProfit)
 * Dynamic Programming, find maxProfit of a single transaction during first i days, find maxProfit of a single transaction during i+1 ~ end
 * 2. https://discuss.leetcode.com/topic/32288/2ms-java-dp-solution/11 (maxProfit1)
 * A tricky dynamic programming method, doesn't require storing profit array.
 * By day i, maxProfit(i) = max(maxProfit(i-1), maxProfit(2nd transaction sold on day i))
 * 3. https://www.cnblogs.com/grandyang/p/4281975.html
 * 4. https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
 * K transactions.
 * TODO: the last two methods can be generalized to k transactions. To be implemented.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] maxProfitLeft = new int[prices.length];
        maxProfitLeft[0] = 0;
        int minPriceLeft = prices[0];
        for (int i=1;i<prices.length;i++) {
            int profit = prices[i] - minPriceLeft;
            maxProfitLeft[i] = Math.max(profit, maxProfitLeft[i-1]);
            minPriceLeft = Math.min(prices[i], minPriceLeft);
        }

        int[] maxProfitRight = new int[prices.length];
        maxProfitRight[prices.length-1] = 0;
        int maxPriceRight = prices[prices.length-1];
        int maxProfit = 0;
        for (int i=prices.length-2;i>=0;i--) {
            int profit = maxPriceRight - prices[i];
            maxProfitRight[i] = Math.max(profit, maxProfitRight[i+1]);
            maxPriceRight = Math.max(prices[i], maxPriceRight);
            maxProfit = Math.max(maxProfit, maxProfitLeft[i]+maxProfitRight[i]);
        }
        return maxProfit;
    }
    public int maxProfit1(int [] prices) {
        int profitAfterBuy1 = Integer.MIN_VALUE;
        int profitAfterSell1 = 0;
        int profitAfterBuy2 = Integer.MIN_VALUE;
        int profitAfterSell2 = 0;
        for (int i=0;i<prices.length;i++) {
            profitAfterBuy1 = Math.max(profitAfterBuy1, -prices[i]);
            profitAfterSell1 = Math.max(profitAfterSell1, profitAfterBuy1 + prices[i]);
            profitAfterBuy2 = Math.max(profitAfterBuy2, profitAfterSell1 - prices[i]);
            profitAfterSell2 = Math.max(profitAfterSell2, profitAfterBuy2 + prices[i]);
        }
        return profitAfterSell2;
    }
}