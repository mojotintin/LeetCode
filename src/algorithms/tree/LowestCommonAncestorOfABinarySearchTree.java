/*
 * Created by calabash on 2017/8/2.
 * Problem Number: 235
 * Problem Name: Lowest Common Ancestor of a Binary Search Tree
 * Difficulty: Easy
 * Related Topics: Tree
 * Source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Description:
 * #---------------------------------------------------------------------------
 * # Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * # two given nodes in the BST.
 * #
 * # According to the definition of LCA on Wikipedia: “The lowest common
 * # ancestor is defined between two nodes v and w as the lowest node in T that
 * # has both v and w as descendants (where we allow a node to be a descendant
 * # of itself).”
 * #       _______6______
 * #      /              \
 * #  ___2__           ___8__
 * # /      \         /      \
 * # 0      _4        7       9
 * #       /  \
 * #       3   5
 * #
 * # For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
 * # Another example is LCA of nodes 2 and 4 is 2, since a node can be a
 * # descendant of itself according to the LCA definition.
 * #---------------------------------------------------------------------------
 */
public class LowestCommonAncestorOfABinarySearchTree {

  /**
   * Submission: 1
   * Status: Accepted
   * Runtime: 9ms
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int min = Math.min(p.val, q.val);
    int max = Math.max(p.val, q.val);
    if (root.val >= min && root.val <=max) {
      return root;
    } else if (root.val > max) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }
}
