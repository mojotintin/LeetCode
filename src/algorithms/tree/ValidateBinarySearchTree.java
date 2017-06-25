package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by Calabash on 2017/6/25.
 * Problem Number : 98
 * Problem Name : Validate Binary Search Tree
 * Description : https://leetcode.com/problems/validate-binary-search-tree/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search
 */
public class ValidateBinarySearchTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public boolean isValidBST(TreeNode root) {
    return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean helper(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    if (root.val > max || root.val < min || min > max ||
        (root.val == Integer.MIN_VALUE && root.left != null) ||
        (root.val == Integer.MAX_VALUE && root.right != null)) {
      return false;
    }
    return helper(root.left, min, root.val - 1) && helper(root.right, root.val + 1, max);
  }
}
