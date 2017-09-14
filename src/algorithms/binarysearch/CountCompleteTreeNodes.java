/*
 * Created by calabash on 2017/9/14.
 * Problem Number: 222.
 * Problem Name: Count Complete Tree Nodes.
 * Difficulty: Medium.
 * Related Topics: Binary Search, Tree.
 * Source: https://leetcode.com/problems/count-complete-tree-nodes/.
 */

package algorithms.binarysearch;

import algorithms.entities.TreeNode;

/**
 * # --------------------------------------------------------------------------
 * # Given a complete binary tree, count the number of nodes.
 * #
 * # Definition of a complete binary tree from Wikipedia
 * # (https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees):
 * # In a complete binary tree every level, except possibly the last, is
 * # completely filled, and all nodes in the last level are as far left as
 * # possible. It can have between 1 and 2h nodes inclusive at the last level
 * # h.
 * # --------------------------------------------------------------------------
 */
public class CountCompleteTreeNodes {
  /**
   * Submission: 1
   * Status: Time Limit Exceeded
   * Time Complexity: o(n)
   */
  public int countNodes_1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return countNodes_1(root.left) + countNodes_1(root.right) + 1;
  }

  /**
   * Submission: 2
   * Status: Accepted
   * Runtime: 158ms
   * Time Complexity: o(log(n) * log(n))
   */
  public int countNodes_2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int height = getHeight(root);
    int min = 1 << height - 1;
    int max = (1 << height) - 1;
    while (min < max) {
      int mid = (min + max) / 2;
      if (getNode(root, mid) == null) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return getNode(root, min) == null ? min - 1 : min;
  }

  // get the height of tree root.
  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return getHeight(root.left) + 1;
  }

  // get the node of tree root with index.
  private TreeNode getNode(TreeNode root, int index) {
    if (index == 1) {
      return root;
    }
    if (index % 2 == 0) {
      return getNode(root, index / 2).left;
    } else {
      return getNode(root, index / 2).right;
    }
  }
}
