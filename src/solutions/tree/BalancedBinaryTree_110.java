package solutions.tree;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/5/17.
 * LeetCode 110th problem
 * Description : https://leetcode.com/problems/balanced-binary-tree/#/description
 * Difficulty : Easy
 * Tags : Tree, Depth-first Search
 */
public class BalancedBinaryTree_110 {

    /**
     * Status : Accepted
     * Runtime : 2ms
     * Note : Recursive
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        else if (root.left == null) return isBalanced(root.right) && depthOfTree(root.right) == 1;
        else if (root.right == null) return isBalanced(root.left) && depthOfTree(root.left) == 1;
        else return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depthOfTree(root.left) - depthOfTree(root.right)) <= 1;
    }

    public int depthOfTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else if (root.left == null) return depthOfTree(root.right) + 1;
        else if (root.right == null) return depthOfTree(root.left) + 1;
        else return Math.max(depthOfTree(root.left), depthOfTree(root.right)) + 1;
    }
}
