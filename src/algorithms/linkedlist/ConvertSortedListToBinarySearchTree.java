package algorithms.linkedlist;

import algorithms.entities.ListNode;
import algorithms.entities.TreeNode;

/**
 * Created by calabash on 2017/6/20.
 * Problem Number : 109
 * Problem Name : Convert Sorted List to Binary Search Tree
 * Description : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/#/description
 * Difficulty : Medium
 * Tags : Depth-First Search, Linked List
 */
public class ConvertSortedListToBinarySearchTree {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 2ms
   */
  public TreeNode sortedListToBST(ListNode head) {
    ListNode node = head;
    int length = 0;
    while (node != null) {
      length += 1;
      node = node.next;
    }
    return helper(head, length);
  }

  private TreeNode helper(ListNode head, int length) {
    if (length == 0) {
      return null;
    }
    if (length == 1) {
      return new TreeNode(head.val);
    }
    if (length == 2) {
      TreeNode root = new TreeNode(head.val);
      root.right = new TreeNode(head.next.val);
      return root;
    }
    ListNode node = head;
    int pos  = (length - 1) / 2;
    for (int i = 0; i < pos - 1; i++) {
      node = node.next;
    }
    TreeNode root = new TreeNode(node.next.val);
    ListNode rHead = node.next.next;
    node.next = null;
    root.left  = helper(head,  pos);
    root.right = helper(rHead, length - 1 - pos);
    return root;
  }
}
