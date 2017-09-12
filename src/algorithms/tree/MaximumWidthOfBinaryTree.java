/*
 * Created by calabash on 2017/9/12.
 * Problem Number: 662.
 * Problem Name: Maximum Width of Binary Tree.
 * Difficulty: Medium.
 * Related Topics: Tree.
 * Source: https://leetcode.com/problems/maximum-width-of-binary-tree/.
 */

package algorithms.tree;

import algorithms.entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Given a binary tree, write a function to get the maximum width of the
 * # given tree. The width of a tree is the maximum width among all levels. The
 * # binary tree has the same structure as a full binary tree, but some nodes
 * # are null.
 * #
 * # The width of one level is defined as the length between the end-nodes (the
 * # leftmost and right most non-null nodes in the level, where the null nodes
 * # between the end-nodes are also counted into the length calculation.
 * #
 * # Example 1:
 * # Input:
 * #        1
 * #      /   \
 * #     3     2
 * #    / \     \
 * #   5   3     9
 * #
 * # Output: 4
 * # Explanation: The maximum width existing in the third level with the length
 * # 4 (5,3,null,9).
 * #
 * # Example 2:
 * # Input:
 * #       1
 * #      /
 * #     3
 * #    / \
 * #   5   3
 * # Output: 2
 * # Explanation: The maximum width existing in the third level with the length
 * # 2 (5,3).
 * #
 * # Example 3:
 * # Input:
 * #       1
 * #      / \
 * #     3   2
 * #    /
 * #   5
 * # Output: 2
 * # Explanation: The maximum width existing in the second level with the
 * # length 2 (3,2).
 * #
 * # Example 4:
 * # Input:
 * #       1
 * #      / \
 * #     3   2
 * #    /     \
 * #   5       9
 * #  /         \
 * # 6           7
 * # Output: 8
 * # Explanation:The maximum width existing in the fourth level with the length
 * # 8 (6,null,null,null,null,null,null,7).
 * # --------------------------------------------------------------------------
 */
public class MaximumWidthOfBinaryTree {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 10ms
   */
  public int widthOfBinaryTree(TreeNode root) {
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    getLeft(root, 0, 1, left);
    getRight(root, 0, 1, right);
    int width = 0;
    for (int i = 0; i < left.size(); i++) {
      width = Math.max(width, right.get(i) - left.get(i) + 1);
    }
    return width;
  }
  private void getLeft(TreeNode root, int height, int index, List<Integer> left) {
    if (root == null) {
      return;
    }
    if (height == left.size()) {
      left.add(index);
    }
    getLeft(root.left, height + 1, index * 2, left);
    getLeft(root.right, height + 1, index * 2 + 1, left);
  }

  private void getRight(TreeNode root, int height, int index, List<Integer> right) {
    if (root == null) {
      return;
    }
    if (height == right.size()) {
      right.add(index);
    }
    getRight(root.right, height + 1, index * 2 + 1, right);
    getRight(root.left, height + 1, index * 2, right);
  }
}
