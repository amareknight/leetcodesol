package MajorityElementII;

import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void majorityElement() throws Exception {
        Solution s = new Solution();
        int[] nums = new int[]{0,3,0,1,2,3,3,4,4,3};
        List<Integer> ret1 = s.majorityElement(nums);
        System.out.println(ret1);
    }
}