package solutions.tree;

import entities.TreeNode;

/**
 * Created by Calabash on 2017/4/24.
 * Problem Number : 563
 * Problem Name : Binary Tree Tilt
 * Description : https://leetcode.com/problems/binary-tree-tilt/#/description
 * Difficulty : Easy
 * Tags : Tree
 */
public class BinaryTreeTilt {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 11ms
   */
  public int findTilt(TreeNode root) {
    if(root == null) return 0;
    sumOfSubtree(root);
    return getTilt(root);
  }

  private void sumOfSubtree(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null && root.right != null) {
      sumOfSubtree(root.left);
      sumOfSubtree(root.right);
      root.val += root.left.val + root.right.val;
    } else if (root.left == null && root.right != null) {
      sumOfSubtree(root.right);
      root.val += root.right.val;
    } else if (root.left != null) {
      sumOfSubtree(root.left);
      root.val += root.left.val;
    } else {
      root.val += 0;
    }
  }

  private int getTilt(TreeNode root) {
    if (root.left == null && root.right == null) {
      return 0;
    } else if (root.left != null && root.right == null) {
      return getTilt(root.left) + root.left.val;
    } else if (root.left == null) {
      return getTilt(root.right) + root.right.val;
    } else {
      return getTilt(root.left) + getTilt(root.right)
          + Math.abs(root.left.val - root.right.val);
    }
  }
}
