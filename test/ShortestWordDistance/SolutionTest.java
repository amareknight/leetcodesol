package ShortestWordDistance;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void shortestDistance() throws Exception {
        Solution s = new Solution();
        int t1 = s.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice");
        int t2 = s.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        Assert.assertEquals(3, t1);
        Assert.assertEquals(1, t2);
    }

}