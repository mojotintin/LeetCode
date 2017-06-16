package algorithms.binarysearch;

import algorithms.entities.TreeNode;

/**
 * Created by Calabash on 2017/6/16.
 * Problem Number : 230
 * Problem Name : Kth Smallest Element in a BST
 * Description : https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/description
 * Difficulty : Medium
 * Tags : Binary Search, Tree
 */
public class KthSmallestElementInABST {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 1ms
   */
  private int count = 0;
  private int kth = 0;

  public int kthSmallest(TreeNode root, int k) {
    order(root, k);
    return kth;
  }

  private void order(TreeNode root, int k) {
    if (root == null){
      return;
    }
    order(root.left,  k);
    count += 1;
    if (k == count) {
      kth = root.val;
      return;
    }
    order(root.right, k);
  }
}
