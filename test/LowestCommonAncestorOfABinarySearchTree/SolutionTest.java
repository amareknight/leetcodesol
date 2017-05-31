package LowestCommonAncestorOfABinarySearchTree;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void lowestCommonAncestorOfABST() {
        Solution s = new Solution();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        int r1 = s.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val;
        int r2 = s.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val;
        Assert.assertEquals(6,r1);
        Assert.assertEquals(2,r2);
    }
}