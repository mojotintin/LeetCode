package solutions.binarysearchtree;

import entities.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Calabash on 2017/6/4.
 * Problem Number : 530
 * Problem Name : Minimum Absolute Difference in BST
 * Description : https://leetcode.com/problems/minimum-absolute-difference-in-bst/#/description
 * Difficulty : Easy
 * Tags : Binary Search Tree
 */
public class MinimumAbsoluteDifferenceInBST {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 18ms
   */
  public int getMinimumDifference(TreeNode root) {
    int minDiff = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();
    order(root, list);
    for (int i = 1; i < list.size(); i++) {
      minDiff = Math.min(minDiff, list.get(i) - list.get(i - 1));
    }
    return minDiff;
  }

  private void order(TreeNode root, List<Integer> list) {
    if (root.left != null) {
      order(root.left, list);
    }
    list.add(root.val);
    if (root.right != null) {
      order(root.right, list);
    }
  }
}
