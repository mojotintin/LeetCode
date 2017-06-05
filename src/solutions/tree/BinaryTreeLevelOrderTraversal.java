package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/25.
 * Problem Number : 102
 * problem Name : Binary Tree Level Order Traversal
 * Description : https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
 * Difficulty : Medium
 * Tags : Tree, Breadth-first Search
 */
public class BinaryTreeLevelOrderTraversal {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 3ms
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    List<TreeNode> level = new ArrayList<>();
    level.add(root);
    while (level.size() != 0) {
      List<Integer> order = new ArrayList<>();
      List<TreeNode> temp = new ArrayList<>();
      for (TreeNode node : level) {
        order.add(node.val);
        if (node.left != null) {
          temp.add(node.left);
        }
        if (node.right != null) {
          temp.add(node.right);
        }
      }
      list.add(order);
      level = temp;
    }
    return list;
  }
}
