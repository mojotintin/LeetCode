package algorithms.tree;

import algorithms.entities.TreeNode;

/**
 * Created by calabash on 2017/3/27.
 * Problem Number : 100
 * Problem Name : Same Tree.
 * Description : https://leetcode.com/problems/same-tree/#/description
 * Difficulty : Easy
 * Tags : Tree, Depth-first Search
 */
public class SameTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 0ms
   */
  public boolean isSameTree_1(TreeNode p, TreeNode q) {
    if (p == null && q ==null){
      return true;
    } else if (p == null){
      return false;
    } else if (q == null){
      return false;
    } else if (p.val != q.val) {
      return false;
    }  else {
      return isSameTree_1(p.left, q.left) && isSameTree_1(p.right, q.right);
    }
  }

  /**
   * Submission : 2
   * Status : Accepted
   * Runtime : 0ms
   */

  public boolean isSameTree_2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null && p.val == q.val) {
            return isSameTree_2(p.left, q.left) && isSameTree_2(p.right, q.right);
        } else {
            return false;
        }
    }
}
