package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by calabash on 2017/3/28.
 * Problem Number : 226
 * Problem Name : Invert Binary Tree
 * Description : https://leetcode.com/problems/invert-binary-tree/#/description
 * Difficulty : Easy
 * Tags : Tree
 */
public class InvertBinaryTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public TreeNode invertTree(TreeNode root) {
    if (root != null && (root.left != null || root.right != null)) {
      TreeNode nodeLeft = invertTree(root.left);
      TreeNode  nodeRight = invertTree(root.right);
      root.left = nodeRight;
      root.right = nodeLeft;
    }
    return root;
  }
}
