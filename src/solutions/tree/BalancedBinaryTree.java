package solutions.tree;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/5/17.
 * Problem Number : 110
 * Problem Name : Balanced Binary Tree
 * Description : https://leetcode.com/problems/balanced-binary-tree/#/description
 * Difficulty : Easy
 * Tags : Tree, Depth-first Search
 */
public class BalancedBinaryTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   * Note : Recursive
   */
  public boolean isBalanced_1(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return true;
    } else if (root.left == null) {
      return isBalanced_1(root.right) && depth(root.right) == 1;
    } else if (root.right == null) {
      return isBalanced_1(root.left) && depth(root.left) == 1;
    } else {
      return isBalanced_1(root.left) && isBalanced_1(root.right)
          && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    } else if (root.left == null) {
      return depth(root.right) + 1;
    } else if (root.right == null) {
      return depth(root.left) + 1;
    } else {
      return Math.max(depth(root.left), depth(root.right)) + 1;
    }
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 1ms
   */
  public boolean isBalanced_2(TreeNode root) {
    return height(root) != -1;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int heightOfLeft = height(root.left);
    int heightOfRight = height(root.right);
    if (heightOfLeft == -1) {
      return -1;
    }
    if (heightOfRight == -1) {
      return -1;
    }
    if (heightOfLeft - heightOfRight > 1
        || heightOfRight - heightOfLeft > 1) {
      return -1;
    }
    return Math.max(heightOfLeft, heightOfRight) + 1;
  }
}
