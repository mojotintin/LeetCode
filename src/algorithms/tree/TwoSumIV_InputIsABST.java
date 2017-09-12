/*
 * Created by calabash on 2017/9/12.
 * Problem Number: 653.
 * Problem Name: Two Sum IV - Input is a BST.
 * Difficulty: Easy.
 * Related Topics: Tree.
 * Source: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/.
 */

package algorithms.tree;

import algorithms.entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Given a Binary Search Tree and a target number, return true if there exist
 * # two elements in the BST such that their sum is equal to the given target.
 * #
 * # Example 1:
 * # Input:
 * #     5
 * #    / \
 * #   3   6
 * #  / \   \
 * # 2   4   7
 * # Target = 9
 * # Output: True
 * #
 * # Example 2:
 * # Input:
 * #     5
 * #    / \
 * #   3   6
 * #  / \   \
 * # 2   4   7
 * # Target = 28
 * # Output: False
 * # --------------------------------------------------------------------------
 */
public class TwoSumIV_InputIsABST {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 28ms
   * Time Complexity: o(n)
   * Space Complexity: o(n)
   */
  public boolean findTarget(TreeNode root, int k) {
    List<Integer> order = new ArrayList<>();
    getOrder(root, order);
    int low = 0;
    int high = order.size() - 1;
    while (low < high) {
      if (order.get(low) + order.get(high) == k) {
        return true;
      } else if (order.get(low) + order.get(high) > k) {
        high -= 1;
      } else {
        low += 1;
      }
    }
    return false;
  }

  private void getOrder(TreeNode root, List<Integer> order) {
    if (root == null) {
      return;
    }
    getOrder(root.left, order);
    order.add(root.val);
    getOrder(root.right, order);
  }
}
