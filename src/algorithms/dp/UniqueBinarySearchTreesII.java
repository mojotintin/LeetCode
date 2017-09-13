/*
 * Created by calabash on 2017/9/13.
 * Problem Number: 95.
 * Problem Name: Unique Binary Search Trees II.
 * Difficulty: Medium.
 * Related Topics: Dynamic Programming.
 * Source: https://leetcode.com/problems/unique-binary-search-trees-ii/.
 */

package algorithms.dp;

import algorithms.entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * # --------------------------------------------------------------------------
 * # Given an integer n, generate all structurally unique BST's (binary search
 * # trees) that store values 1...n.
 * #
 * # For example,
 * # Given n = 3, your program should return all 5 unique BST's shown below.
 * #
 * #    1         3     3      2      1
 * #     \       /     /      / \      \
 * #      3     2     1      1   3      2
 * #     /     /       \                 \
 * #    2     1         2                 3
 * # --------------------------------------------------------------------------
 */
public class UniqueBinarySearchTreesII {
  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 3ms
   */
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    List<List<TreeNode>> list = new ArrayList<>();
    List<TreeNode> trees0 = new ArrayList<>();
    List<TreeNode> trees1 = new ArrayList<>();
    trees0.add(null);
    trees1.add(new TreeNode(1));
    list.add(trees0);
    list.add(trees1);
    for (int i = 2; i <= n; i++) {
      List<TreeNode> trees = new ArrayList<>();
      for (int j = 1; j <= i; j++) {
        // when the root of tree is j
        for (TreeNode tree1 : list.get(j - 1)) {
          for (TreeNode tree2 : list.get(i - j)) {
            TreeNode root = new TreeNode(j);
            root.left = copyOfTree(tree1, 0);
            root.right = copyOfTree(tree2, j);
            trees.add(root);
          }
        }
      }
      list.add(trees);
    }
    return list.get(n);
  }

  // return a copy of Tree p with diff
  private TreeNode copyOfTree(TreeNode p, int diff) {
    if (p == null) {
      return null;
    }
    TreeNode q = new TreeNode(p.val + diff);
    q.left = copyOfTree(p.left, diff);
    q.right = copyOfTree(p.right, diff);
    return q;
  }
}
