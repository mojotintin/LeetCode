package algorithms.tree;

import algorithms.entities.TreeLinkNode;

/**
 * Created by Calabash on 2017/6/9.
 * Problem Number : 117
 * Problem Name : Populating Next Right Pointers in Each Node II
 * Description : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/#/description
 * Difficulty : Medium
 * Tags : Tree, Depth-first Search
 */
public class PopulatingNextRightPointersInEachNodeII {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   */
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    TreeLinkNode node = root;
    while (node != null) {
      TreeLinkNode pre = null;
      TreeLinkNode start = null;
      while (node != null) {
        if (node.left != null) {
          if (pre != null) {
            pre.next = node.left;
          } else {
            start = node.left;
          }
          pre = node.left;
        }
        if (node.right != null) {
          if (pre != null) {
            pre.next = node.right;
          } else {
            start = node.right;
          }
          pre = node.right;
        }
        node = node.next;
      }
      node = start;
    }
  }
}
