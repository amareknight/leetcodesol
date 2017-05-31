package LowestCommonAncestorOfABinarySearchTree;

/**
 * Definition for a binary tree node.
 */
// Nodes p,q are given from the BST so it's unnecessary to check if p,q exists.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode s = p.val < q.val ? p : q;
        TreeNode l = p.val < q.val ? q : p;
        if (root.val < s.val) return lowestCommonAncestor(root.right, s, l);
        if (root.val > l.val) return lowestCommonAncestor(root.left, s, l);
        return root;
    }
}