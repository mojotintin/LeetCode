package solutions.tree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/5/11.'
 * Problem Number : 94
 * Problem Name : Binary Tree Inorder Traversal
 * Description : https://leetcode.com/problems/binary-tree-inorder-traversal/#/description
 * Difficulty : Medium
 * Tags : Tree, Hash Table, Stack
 */
public class BinaryTreeInorderTraversal {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  private List<Integer> traversal = new ArrayList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    if(root == null) {
      return traversal;
    }
    if(root.left != null) {
      inorderTraversal(root.left);
    }
    traversal.add(root.val);
    if(root.right != null) {
      inorderTraversal(root.right);
    }
    return traversal;
  }
}
