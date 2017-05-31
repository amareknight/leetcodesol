package MaximumSubarray;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void maximumSubArrayTest() throws Exception {
        Solution s = new Solution();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(6, s.maxSubArray(arr));
        Assert.assertEquals(6, s.maxSubArray1(arr));
        Assert.assertEquals(6, s.maxSubArray2(arr));
    }

}