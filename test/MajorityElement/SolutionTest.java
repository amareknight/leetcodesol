package MajorityElement;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void majorityElement() throws Exception {
        Solution s = new Solution();
        int[] nums = new int[]{3,4,5,4,4,10,4};
        int ret1 = s.majorityElement(nums);
        int ret2 = s.majorityElement1(nums);
        Assert.assertEquals(4,ret1);
        Assert.assertEquals(4,ret2);
    }
}