package BestTimetoBuyandSellStockIII;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void testProfit() {
        Solution s = new Solution();
        int[] prices = new int[]{8,3,2,4,5,6,8,9,13,3,1,8,9,4,13,12,11,22,23,30};
        int result = s.maxProfit1(prices);
        System.out.println("result"+result);
    }
}