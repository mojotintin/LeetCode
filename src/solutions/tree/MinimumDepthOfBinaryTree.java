package solutions.tree;

import entities.TreeNode;

/**
 * Created by calabash on 2017/4/6.
 * Problem Number : 111
 * Problem Name : Minimum Depth of Binary Tree
 * Description : https://leetcode.com/problems/minimum-depth-of-binary-tree/#/description
 * Difficulty : Easy
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class MinimumDepthOfBinaryTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   */
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return 1;
    } else if (root.left != null && root.right != null) {
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    } else {
      return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }
  }
}
