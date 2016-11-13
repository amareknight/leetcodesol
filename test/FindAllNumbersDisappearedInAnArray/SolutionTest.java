package FindAllNumbersDisappearedInAnArray;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {
    @Test
    public void findDisappearedNumbers() throws Exception {
        Solution s = new Solution();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> r = s.findDisappearedNumbers(nums);
        Assert.assertEquals(Arrays.asList(5,6), r);
    }

}