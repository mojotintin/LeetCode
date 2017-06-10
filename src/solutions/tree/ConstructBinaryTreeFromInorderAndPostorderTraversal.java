package solutions.tree;

import entities.TreeNode;

import java.util.Arrays;

/**
 * Created by Calabash on 2017/6/10.
 * Problem Number : 106
 * Problem Name : Construct Binary Tree from Inorder and Postorder Traversal
 * Description : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/#/description
 * Difficulty : Medium
 * Tags : Tree, Array, Depth-first Search
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 30ms
   */
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[inorder.length - 1]);
    int mid = 0;
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == postorder[inorder.length - 1]) {
        mid = i;
        break;
      }
    }
    if (mid != 0) {
      root.left  = buildTree(Arrays.copyOfRange(inorder, 0, mid),
          Arrays.copyOfRange(postorder, 0, mid));
    }
    if (mid != inorder.length - 1) {
      root.right = buildTree(Arrays.copyOfRange(inorder, mid + 1, inorder.length),
          Arrays.copyOfRange(postorder, mid, inorder.length - 1));
    }
    return root;
  }
}
