package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by Calabash on 2017/6/5.
 * Problem Number : 337
 * Problem Name : House Robber III
 * Description : https://leetcode.com/problems/house-robber-iii/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search
 */
public class HouseRobberIII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int val1 = 0;
    int val2 = 0;
    if (root.right != null) {
      val1 += rob(root.right);
      if (root.right.right != null) {
        val2 += root.right.right.val;
      }
      if (root.right.left != null) {
        val2 += root.right.left.val;
      }
    }
    if (root.left != null) {
      val1 += rob(root.left);
      if (root.left.right != null) {
        val2 += root.left.right.val;
      }
      if (root.left.left != null) {
        val2 += root.left.left.val;
      }
    }
    root.val = Math.max(val1, val2 + root.val);
    return root.val;
  }
}
