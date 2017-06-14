package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by calabash on 2017/5/28.
 * Problem Number : 543
 * Problem Name : Diameter of Binary Tree
 * Description : https://leetcode.com/problems/diameter-of-binary-tree/#/description
 * Difficulty : Easy
 * Tags : Tree
 */
public class DiameterOfBinaryTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 11ms
   */
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return desOfBinaryTree(root)[1];
  }

  private int[] desOfBinaryTree(TreeNode root) {
    if (root.left == null && root.right == null) {
      return new int[]{0, 0};
    } else if (root.left == null) {
      int[] des = desOfBinaryTree(root.right);
      return new int[]{des[0] + 1, Math.max(des[1], des[0] + 1)};
    } else if (root.right == null) {
      int[] des = desOfBinaryTree(root.left);
      return new int[]{des[0] + 1, Math.max(des[1], des[0] + 1)};
    } else {
      int[] desLeft = desOfBinaryTree(root.left);
      int[] desRight = desOfBinaryTree(root.right);
      return new int[]{Math.max(desLeft[0] + 1, desRight[0] + 1),
          Math.max(Math.max(desLeft[1] , desRight[1]),
              desLeft[0] + desRight[0] + 2)};
    }
  }
}
