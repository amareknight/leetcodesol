package ValidAnagram;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void validAnagramTest() throws Exception {
        Solution s = new Solution();
        Assert.assertTrue(s.isAnagram("anagram", "nagaram"));
        Assert.assertFalse(s.isAnagram("rat", "car"));
    }

}