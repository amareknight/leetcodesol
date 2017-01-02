package BestTimetoBuyandSellStockII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest{
    @Test
    public void testProfit(){
        int[] prices = new int[]{3,4,5,6,7,5,2,8};
        Solution s = new Solution();
        int result = s.maxProfitSimp(prices);
        assertEquals(10,result);
    }
}