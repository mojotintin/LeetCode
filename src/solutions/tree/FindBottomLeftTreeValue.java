package solutions.tree;

import entities.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by calabash on 2017/4/6.
 * Problem Number : 513
 * Problem Name : Find Bottom Left Tree Value
 * Description : https://leetcode.com/problems/find-bottom-left-tree-value/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search, Breadth-first Search
 */
public class FindBottomLeftTreeValue {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 9ms
   */
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    TreeNode node = null;
    while (!queue.isEmpty()){
      node = queue.poll();
      if (node.right != null) {
        queue.add(node.right);
      }
      if (node.left != null) {
        queue.add(node.left);
      }
    }
    return node.val;
  }
}
