package BestTimetoBuyandSellStock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Result = max - min
 * Scan the array, record the min till now and calculate the result after scanning an element.
 */
public class SolutionTest {
    @Test
    public void testProfit() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        int result = solution.maxProfit(prices);
        assertEquals(5,result);
    }
}