package solutions.tree;

import entities.TreeNode;

import java.util.Arrays;

/**
 * Created by Calabash on 2017/6/9.
 * Problem Number : 105
 * Problem Name : Construct Binary Tree from Preorder and Inorder Traversal
 * Description : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/#/description
 * Difficulty : Medium
 * Tags : Tree, Array, Depth-first Search
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 43ms
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    int mid = 0;
    for (int i = 0; i < preorder.length; i++) {
      if (inorder[i] == preorder[0]) {
        mid = i;
        break;
      }
    }
    if (mid != 0) {
      root.left  = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1),
          Arrays.copyOfRange(inorder, 0, mid));
    }
    if (mid != preorder.length - 1) {
      root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
          Arrays.copyOfRange(inorder, mid + 1, inorder.length));
    }
    return root;
  }
}
