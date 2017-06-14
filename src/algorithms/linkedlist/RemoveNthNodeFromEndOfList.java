package algorithms.linkedlist;

import algorithms.entities.ListNode;

/**
 * Created by Calabash on 2017/5/18.
 * Problem NUmber : 19
 * Problem Name : Remove Nth Node From End of List
 * Description : https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description
 * Difficulty : Medium
 * Tags : Linked List, Two Points
 */
public class RemoveNthNodeFromEndOfList {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 15ms
   * Note : Two points
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode nodeToEnd = newHead;
    ListNode nodeToDelete = newHead;
    int gap = 0;
    while (nodeToEnd.next != null) {
      nodeToEnd = nodeToEnd.next;
      if (gap >= n) {
        nodeToDelete = nodeToDelete.next;
      }
      gap++;
    }
    nodeToDelete.next = nodeToDelete.next.next;
    return newHead.next;
  }
}
