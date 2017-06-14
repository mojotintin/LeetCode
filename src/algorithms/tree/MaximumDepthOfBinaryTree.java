package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by calabash on 2017/4/7.
 * Problem Number : 104
 * Problem Name : Maximum Depth of Binary Tree
 * Description : https://leetcode.com/problems/maximum-depth-of-binary-tree/#/description
 * Difficulty : Easy
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class MaximumDepthOfBinaryTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
  }
}
