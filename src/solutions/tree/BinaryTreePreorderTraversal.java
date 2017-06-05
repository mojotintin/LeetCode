package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Calabash on 2017/5/12.
 * Problem Number : 144
 * Problem Name : Binary Tree Preorder Traversal
 * Description : https://leetcode.com/problems/binary-tree-preorder-traversal/#/description
 * Difficulty : Medium
 * Tags : Tree, Stack
 */
public class BinaryTreePreorderTraversal {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   * Note : recursion
   */
  List<Integer> list = new ArrayList<>();

  public List<Integer> preorderTraversal_1(TreeNode root) {
    if(root == null) {
      return list;
    }
    list.add(root.val);
    if(root.left != null) {
      preorderTraversal_1(root.left);
    }
    if(root.right != null) {
      preorderTraversal_1(root.right);
    }
    return list;
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 2ms
   * Note : Stack
   */
  public List<Integer> preorderTraversal_2(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) {
      return list;
    }
    stack.push(root);
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      list.add(node.val);
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return list;
  }
}
