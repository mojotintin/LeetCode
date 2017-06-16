package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by Calabash on 2017/6/16.
 * Problem Number : 538
 * Problem Name : Convert BST to Greater Tree
 * Description : https://leetcode.com/problems/convert-bst-to-greater-tree/#/description
 * Difficulty : Medium
 * Tags : Tree
 */
public class ConvertBSTToGreaterTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 18ms
   */
  public TreeNode convertBST(TreeNode root) {
    updateUp(root);
    updateDown(root, 0);
    return root;
  }

  private int updateUp(TreeNode root) {
    if (root == null) {
      return 0;
    }else{
      root.val += updateUp(root.left) + updateUp(root.right);
      return root.val;
    }
  }

  private void updateDown(TreeNode root, int father) {
    if(root == null) {
      return;
    }
    if (root.left != null) {
      root.val -= root.left.val;
    }
    root.val += father;
    updateDown(root.left,  root.val);
    updateDown(root.right, father);
  }
}
